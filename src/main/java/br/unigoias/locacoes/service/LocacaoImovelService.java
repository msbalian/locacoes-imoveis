package br.unigoias.locacoes.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.locacoes.model.Cobranca;
import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.model.LocacaoImovel;
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

	public LocacaoImovel save(Long imovelId, LocacaoImovel locacao) {

		Optional<Imovel> imovel = imovelRepository.findById(imovelId);

		if (imovel.isPresent()) {

			locacao.setImovel(imovel.get());
			return locacaoRepository.save(locacao);

		}

		return null;

	}

	public List<LocacaoImovel> findByImovelId(Long imovelId) {

		Optional<Imovel> imovel = imovelRepository.findById(imovelId);

		if (imovel.isPresent()) {

			return locacaoRepository.findByImovel(imovel.get());

		}

		return null;

	}

	@Transactional
	public ResponseEntity<Cobranca> processarCobranca(Long locacaoId, ImpostoService impostoService) {
		
		Optional<LocacaoImovel> locacaoOptional = locacaoRepository.findById(locacaoId);
		
		if (locacaoOptional.isPresent()) {
			LocacaoImovel locacao = locacaoOptional.get();
			int diarias = locacao.getQuantidadeDiarias();
			double valorPrincipal = locacao.getValorPorDiaria() * diarias;
			double valorImposto = impostoService.calcularImposto(valorPrincipal);
			Cobranca cobranca = new Cobranca();
			cobranca.setValorPrincipal(valorPrincipal);
			cobranca.setValorImposto(valorImposto);
			cobranca.setValorPagamento(valorPrincipal+valorImposto);
			locacao.setCobranca(cobranca);
			cobrancaRepository.save(cobranca);
			locacaoRepository.save(locacao);
			return ResponseEntity.ok(cobranca);
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
