package br.unigoias.locacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.model.LocacaoImovel;
import br.unigoias.locacoes.repository.ImovelRepository;
import br.unigoias.locacoes.repository.LocacaoImovelRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository imovelRepository;
	
	@Autowired
	private LocacaoImovelRepository locacaoRepository;
	
	public List<Imovel> findAll() {
		
		return imovelRepository.findAll();
		
	}
	
	
	public ResponseEntity<Imovel> findById(Long id) {
		
		Optional<Imovel> imovel = imovelRepository.findById(id);
		
		if (imovel.isPresent()) {
			return ResponseEntity.ok(imovel.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<Imovel> deleteById(Long id) {
		
		if (imovelRepository.existsById(id)) {
			
			imovelRepository.deleteById(id);
			return ResponseEntity.noContent().build();
			
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<Imovel> updateById(Long id, Imovel novoImovel) {
		
		if (imovelRepository.existsById(id)) {
			novoImovel.setId(id);
			return ResponseEntity.ok(imovelRepository.save(novoImovel));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	
	public ResponseEntity<Imovel> save(Imovel imovel) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(imovelRepository.save(imovel));

	}
	
	public ResponseEntity<LocacaoImovel> saveByImovelId(Long imovelId, LocacaoImovel locacaoImovel) {
		
		Optional<Imovel> imovel = imovelRepository.findById(imovelId);
				
		if (imovel.isPresent()) {
			
			locacaoImovel.setImovel(imovel.get());
			locacaoRepository.save(locacaoImovel);
			return ResponseEntity.status(HttpStatus.CREATED).body(locacaoImovel);
			
		}
		
		return ResponseEntity.notFound().build();
		
	}


	public List<LocacaoImovel> findAllByImovelId(Long imovelId) {

		Optional<Imovel> imovel = imovelRepository.findById(imovelId);
		
		if (imovel.isPresent()) {
		
			return locacaoRepository.findByImovel(imovel.get());
		
		}
		
		return null;
		
		
	}
	
	
}
