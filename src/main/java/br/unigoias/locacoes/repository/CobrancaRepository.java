package br.unigoias.locacoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unigoias.locacoes.model.Cobranca;
import br.unigoias.locacoes.model.LocacaoImovel;

@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{

	List<Cobranca> findByLocacaoImovel(LocacaoImovel locacaoImovel);
	
	
}
