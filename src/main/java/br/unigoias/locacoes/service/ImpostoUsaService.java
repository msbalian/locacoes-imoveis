package br.unigoias.locacoes.service;

public class ImpostoUsaService implements ImpostoService {

	@Override
	public double calcularImposto(double baseDeCalculo) {

		return baseDeCalculo*0.30;
		
	}

}
