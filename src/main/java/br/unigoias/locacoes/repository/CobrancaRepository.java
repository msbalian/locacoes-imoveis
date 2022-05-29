package br.unigoias.locacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unigoias.locacoes.model.Cobranca;

@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long>{

}
