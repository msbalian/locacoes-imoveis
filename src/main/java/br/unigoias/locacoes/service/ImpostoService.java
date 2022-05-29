package br.unigoias.locacoes.service;

import org.springframework.stereotype.Service;

@Service
public interface ImpostoService {
	
	Double calcularImposto(Double baseDeCalculo);

}
