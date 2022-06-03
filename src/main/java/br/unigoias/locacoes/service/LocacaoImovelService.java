package br.unigoias.locacoes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.locacoes.model.Cobranca;
import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.model.LocacaoImovel;
import br.unigoias.locacoes.model.dto.CobrancaDTO;
import br.unigoias.locacoes.model.dto.LocacaoImovelDTO;
import br.unigoias.locacoes.repository.CobrancaRepository;
import br.unigoias.locacoes.repository.ImovelRepository;
import br.unigoias.locacoes.repository.LocacaoImovelRepository;

@Service
public class LocacaoImovelService {

	@Autowired
	private LocacaoImovelRepository locacaoRepository;

	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private CobrancaRepository cobrancaRepository;

	public LocacaoImovel findById(Long id) {
		return locacaoRepository.findById(id).orElse(null);
	}

	public LocacaoImovelDTO save(Long imovelId, LocacaoImovelDTO locacaoDTO) {

		Optional<Imovel> imovel = imovelRepository.findById(imovelId);

		if (imovel.isPresent()) {
			LocacaoImovel locacao = new LocacaoImovel();
			locacao.setImovel(imovel.get());
			locacao.setQuantidadeDiarias(locacao.getQuantidadeDiarias());
			locacao.setValorPorDiaria(locacaoDTO.getValorPorDiaria());
			locacaoRepository.save(locacao);
			return new LocacaoImovelDTO(locacao);

		}

		return null;

	}

	public List<LocacaoImovelDTO> findByImovelId(Long imovelId) {

		Optional<Imovel> imovel = imovelRepository.findById(imovelId);

		if (imovel.isPresent()) {

			return locacaoRepository.findByImovel(imovel.get())
					.stream()
					.map(loc -> new LocacaoImovelDTO(loc))
					.collect(Collectors.toList());

		}

		return null;

	}

	@Transactional
	public ResponseEntity<CobrancaDTO> processarCobranca(Long locacaoId, CobrancaDTO cobrancaDTO) {
		
		Optional<LocacaoImovel> locacaoOptional = locacaoRepository.findById(locacaoId);
		
		if (locacaoOptional.isPresent()) {
			LocacaoImovel locacao = locacaoOptional.get();
			int diarias = locacao.getQuantidadeDiarias();
			double valorPrincipal = locacao.getValorPorDiaria() * diarias;
			ImpostoService impostoService;
			switch (cobrancaDTO.getPaisTributacao().toUpperCase()) {
			case "BRASIL":
				impostoService = new ImpostoBrasilService();	
				break;

			case "USA":
				impostoService = new ImpostoUsaService();
				break;
				
			default:
				impostoService = new ImpostoBrasilService();
				break;
			}
			
			double valorImposto = impostoService.calcularImposto(valorPrincipal);
			Cobranca cobranca = new Cobranca();
			cobranca.setValorPrincipal(valorPrincipal);
			cobranca.setValorImposto(valorImposto);
			cobranca.setValorPagamento(valorPrincipal+valorImposto);
			cobranca.setLocacaoImovel(locacao);
			locacao.setCobranca(cobranca);
			cobrancaRepository.save(cobranca);
			locacaoRepository.save(locacao);

			cobrancaDTO.setValorImposto(cobranca.getValorImposto());
			cobrancaDTO.setValorPrincipal(cobranca.getValorPrincipal());
			cobrancaDTO.setValorPagamento(cobranca.getValorPagamento());
			return ResponseEntity.ok(cobrancaDTO);
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
