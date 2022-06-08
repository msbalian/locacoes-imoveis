package br.unigoias.locacoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unigoias.locacoes.model.LocacaoImovel;
import br.unigoias.locacoes.model.dto.PaisTributacaoDTO;
import br.unigoias.locacoes.service.ImpostoBrasilService;
import br.unigoias.locacoes.service.ImpostoService;
import br.unigoias.locacoes.service.ImpostoUsaService;
import br.unigoias.locacoes.service.LocacaoImovelService;

@RestController
@RequestMapping("/locacoes")
public class LocacaoImovelController {

	@Autowired
	private LocacaoImovelService locacaoService;
	
	@PutMapping("/{locacaoImovelId}/cobrancas")
	public LocacaoImovel processarCobranca(@PathVariable Long locacaoImovelId, @RequestBody PaisTributacaoDTO paisTributacaoDTO) {
		
		ImpostoService impostoService;
		
		switch (paisTributacaoDTO.getNomePais().toUpperCase()) {
		case "BRASIL":
			impostoService = new ImpostoBrasilService();
			break;

		case "USA":
			impostoService = new ImpostoUsaService();
			break;

		default:
			impostoService = new ImpostoBrasilService();
			break;
		}
		
		return locacaoService.processarCobranca(locacaoImovelId, impostoService);
	}
	
}
