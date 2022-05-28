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
	public List<Imovel> findAll() {
		return imovelService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Imovel> findById(@PathVariable Long id) {
		return imovelService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Imovel> deleteById(@PathVariable Long id) {
		return imovelService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Imovel> updateById(@PathVariable Long id, @RequestBody Imovel novoImovel) {
		return imovelService.updateById(id, novoImovel);
	}

	@PostMapping
	public Imovel save(@RequestBody Imovel imovel) {
		return imovelService.save(imovel);
	}
	
	@GetMapping("/{imovelId}/locacoes")
	public List<LocacaoImovel> findByImovelId(@PathVariable Long imovelId) {
		return locacaoService.findByImovelId(imovelId);
	}
	
	@PostMapping("/{imovelId}/locacoes")
	public LocacaoImovel save(@PathVariable Long imovelId, @RequestBody LocacaoImovel locacaoImovel) {
		return locacaoService.save(imovelId, locacaoImovel);
	}	
		
}
