package br.unigoias.locacoes.service;

import org.springframework.stereotype.Component;

@Component
public interface ImpostoService {

	double calcularImposto(double baseDeCalculo);
	
}
