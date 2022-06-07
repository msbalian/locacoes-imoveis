package br.unigoias.locacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unigoias.locacoes.model.Imovel;
import br.unigoias.locacoes.model.LocacaoImovel;

@Repository
public interface LocacaoImovelRepository extends JpaRepository<LocacaoImovel, Long>{

	List<LocacaoImovel> findByImovel(Imovel imovel);
	
}
