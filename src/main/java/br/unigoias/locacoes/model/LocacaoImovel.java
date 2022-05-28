package br.unigoias.locacoes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LocacaoImovel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantidadeDiarias;
	
	@ManyToOne
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;
	
	public LocacaoImovel() {
	}

	public LocacaoImovel(Long id, Integer quantidadeDiarias, Imovel imovel) {
		this.id = id;
		this.quantidadeDiarias = quantidadeDiarias;
		this.imovel = imovel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidadeDiarias() {
		return quantidadeDiarias;
	}

	public void setQuantidadeDiarias(Integer quantidadeDiarias) {
		this.quantidadeDiarias = quantidadeDiarias;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	
	
}
