package br.unigoias.locacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unigoias.locacoes.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{

}
