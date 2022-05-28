package br.unigoias.locacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.repository.ImovelRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository imovelRepositoy;
	
	public List<Imovel> findAll() {
		
		return imovelRepositoy.findAll();
		
	}
	
	
	public ResponseEntity<Imovel> findById(Long id) {
		
		Optional<Imovel> imovel = imovelRepositoy.findById(id);
		
		if (imovel.isPresent()) {
			return ResponseEntity.ok(imovel.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<Imovel> deleteById(Long id) {
		
		if (imovelRepositoy.existsById(id)) {
			
			imovelRepositoy.deleteById(id);
			return ResponseEntity.noContent().build();
			
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<Imovel> updateById(Long id, Imovel novoImovel) {
		
		if (imovelRepositoy.existsById(id)) {
			novoImovel.setId(id);
			return ResponseEntity.ok(imovelRepositoy.save(novoImovel));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	
	public Imovel save(Imovel imovel) {
		return imovelRepositoy.save(imovel);
	}
	
}
