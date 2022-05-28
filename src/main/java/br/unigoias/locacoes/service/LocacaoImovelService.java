package br.unigoias.locacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.model.LocacaoImovel;
import br.unigoias.locacoes.repository.ImovelRepository;
import br.unigoias.locacoes.repository.LocacaoImovelRepository;

@Service
public class LocacaoImovelService {
	
	@Autowired
	private LocacaoImovelRepository locacaoRepository;

	@Autowired
	private ImovelRepository imovelRepository;
		
	public LocacaoImovel findById(Long id) {
		return locacaoRepository.findById(id).orElse(null);
	}
	
	public LocacaoImovel save(Long imovelId, LocacaoImovel locacao) {
		
		Optional<Imovel> imovel = imovelRepository.findById(imovelId);
		
		if (imovel.isPresent()) {
			
			locacao.setImovel(imovel.get());
			return locacaoRepository.save(locacao);

		}
		
		return null;
		
		
	}
		
	public List<LocacaoImovel> findByImovelId(Long imovelId) {
		
		Optional<Imovel> imovel = imovelRepository.findById(imovelId);
		
		if (imovel.isPresent()) {

			return locacaoRepository.findByImovel(imovel.get());
			
		}
		
		return null;
		

		
	}
	
	

}
