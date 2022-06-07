package br.unigoias.locacoes.service;

public class ImpostoBrasilService implements ImpostoService {

	@Override
	public double calcularImposto(double baseDeCalculo) {

		if (baseDeCalculo > 1000) {
			return baseDeCalculo*0.2;
		}
		
		return baseDeCalculo*0.15;
		
	}

}
