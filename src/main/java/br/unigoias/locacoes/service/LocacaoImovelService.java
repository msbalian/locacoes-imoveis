package br.unigoias.locacoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unigoias.locacoes.model.Cobranca;
import br.unigoias.locacoes.model.LocacaoImovel;
import br.unigoias.locacoes.repository.CobrancaRepository;
import br.unigoias.locacoes.repository.LocacaoImovelRepository;

@Service
public class LocacaoImovelService {

	@Autowired
	private LocacaoImovelRepository locacaoImovelRepository;

	@Autowired
	private CobrancaRepository cobrancaRepository;

	public LocacaoImovel processarCobranca(Long locacaoImovelId, ImpostoService impostoService) {

		Optional<LocacaoImovel> locacaoOptional = locacaoImovelRepository.findById(locacaoImovelId);

		if (locacaoOptional.isPresent()) {

			LocacaoImovel locacao = locacaoOptional.get();

			double valorPrincipal = locacao.getValorPorDiaria() * locacao.getQuantidadeDiarias();

			double valorImposto = impostoService.calcularImposto(valorPrincipal);

			double valorPagamento = valorPrincipal + valorImposto;

			if (locacao.getCobranca() == null) {
				
				Cobranca cobranca = new Cobranca();
				cobranca.setLocacaoImovel(locacao);
				cobranca.setValorPrincipal(valorPrincipal);
				cobranca.setValorImposto(valorImposto);
				cobranca.setValorPagamento(valorPagamento);
				locacao.setCobranca(cobranca);
				cobrancaRepository.save(cobranca);

			} else {

				locacao.getCobranca().setValorPrincipal(valorPrincipal);
				locacao.getCobranca().setValorImposto(valorImposto);
				locacao.getCobranca().setValorPagamento(valorPagamento);
				cobrancaRepository.save(locacao.getCobranca());
			}

			
			locacaoImovelRepository.save(locacao);

			return locacao;

		} else {

			return null;

		}

	}

}
