package br.unigoias.locacoes.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.unigoias.locacoes.model.Cobranca;
import br.unigoias.locacoes.model.LocacaoImovel;
import br.unigoias.locacoes.repository.CobrancaRepository;
import br.unigoias.locacoes.repository.LocacaoImovelRepository;

public class LocacaoImovelService {

	private ImpostoService impostoService;
	
	@Autowired
	private LocacaoImovelRepository locacaoImovelRepository;
	
	@Autowired
	private CobrancaRepository cobrancaRepository;
	
	public LocacaoImovelService(ImpostoService impostoService) {
		this.impostoService = impostoService;
	}
	
	public void processarCobranca(LocacaoImovel locacao) {
		
		double valorPrincipal = locacao.getValorPorDiaria() * locacao.getQuantidadeDiarias();
		
		double valorImposto = this.impostoService.calcularImposto(valorPrincipal);
		
		double valorPagamento = valorPrincipal + valorImposto;
		
		Cobranca cobranca = new Cobranca();
		
		cobranca.setValorPrincipal(valorPrincipal);
		cobranca.setValorImposto(valorImposto);
		cobranca.setValorPagamento(valorPagamento);
		cobranca.setLocacaoImovel(locacao);
		locacao.setCobranca(cobranca);
		
		cobrancaRepository.save(cobranca);
		
		
		
		
	}
	
	
}
