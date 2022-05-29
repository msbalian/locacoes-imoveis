package br.unigoias.locacoes.service;

public class ImpostoBrasilService implements ImpostoService{

	@Override
	public Double calcularImposto(Double baseDeCalculo) {
		
		if (baseDeCalculo >= 1000.00) {
			return baseDeCalculo*0.2;
		}
		
		return baseDeCalculo*0.15;
		
	}

}
