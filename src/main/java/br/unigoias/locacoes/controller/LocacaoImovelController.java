package br.unigoias.locacoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unigoias.locacoes.service.ImpostoBrasilService;
import br.unigoias.locacoes.service.LocacaoImovelService;

@RestController
@RequestMapping("/locacoes")
public class LocacaoImovelController {

	@Autowired
	private LocacaoImovelService locacaoService;
	

	@PutMapping("/{locacaoId}/cobrancas")
	public ResponseEntity<?> processarCobranca(@PathVariable Long locacaoId) {
		return locacaoService.processarCobranca(locacaoId, new ImpostoBrasilService());
	}
	

	
	
	
}
