package br.unigoias.locacoes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.model.dto.ImovelDTO;
import br.unigoias.locacoes.repository.ImovelRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository imovelRepository;
	
	public List<ImovelDTO> findAll() {
		
		List<Imovel> imoveis = imovelRepository.findAll();
		return imoveis.stream()
				.map(imovel -> new ImovelDTO(imovel))
				.collect(Collectors.toList());
		
	}
	
	
	public ResponseEntity<ImovelDTO> findById(Long id) {
		
		Optional<Imovel> imovel = imovelRepository.findById(id);
		
		if (imovel.isPresent()) {
			return ResponseEntity.ok(new ImovelDTO(imovel.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<ImovelDTO> deleteById(Long id) {
		
		if (imovelRepository.existsById(id)) {
			
			imovelRepository.deleteById(id);
			return ResponseEntity.noContent().build();
			
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<ImovelDTO> updateById(Long id, Imovel novoImovel) {
		
		if (imovelRepository.existsById(id)) {
			novoImovel.setId(id);
			return ResponseEntity.ok(new ImovelDTO(imovelRepository.save(novoImovel)));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	
	public ImovelDTO save(ImovelDTO imovelDTO) {
		Imovel imovel = new Imovel(imovelDTO.getId(), imovelDTO.getDescricao());
		imovelRepository.save(imovel);
		return new ImovelDTO(imovel);
	}
	
}
