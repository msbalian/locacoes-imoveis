package br.unigoias.locacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.model.LocacaoImovel;
import br.unigoias.locacoes.model.dto.ImovelDTO;
import br.unigoias.locacoes.model.dto.LocacaoImovelDTO;
import br.unigoias.locacoes.service.ImovelService;
import br.unigoias.locacoes.service.LocacaoImovelService;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private LocacaoImovelService locacaoService; 
	
	@GetMapping
	public List<ImovelDTO> findAll() {
		return imovelService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ImovelDTO> findById(@PathVariable Long id) {
		return imovelService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ImovelDTO> deleteById(@PathVariable Long id) {
		return imovelService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ImovelDTO> updateById(@PathVariable Long id, @RequestBody Imovel novoImovel) {
		return imovelService.updateById(id, novoImovel);
	}

	@PostMapping
	public ImovelDTO save(@RequestBody ImovelDTO imovelDTO) {
		return imovelService.save(imovelDTO);
	}
	
	@GetMapping("/{imovelId}/locacoes")
	public List<LocacaoImovelDTO> findByImovelId(@PathVariable Long imovelId) {
		return locacaoService.findByImovelId(imovelId);
	}
	
	@PostMapping("/{imovelId}/locacoes")
	public LocacaoImovelDTO save(@PathVariable Long imovelId, @RequestBody LocacaoImovelDTO locacaoImovelDTO) {
		return locacaoService.save(imovelId, locacaoImovelDTO);
	}	
		
}
