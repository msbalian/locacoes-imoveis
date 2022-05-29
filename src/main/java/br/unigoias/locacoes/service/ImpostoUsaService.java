package br.unigoias.locacoes.service;

public class ImpostoUsaService implements ImpostoService{

	@Override
	public Double calcularImposto(Double baseDeCalculo) {
		
		return baseDeCalculo*0.1;
		
	}

}
