package br.unigoias.locacoes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LocacaoImovel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantidadeDiarias;
	
	private Long valorPorDiaria;
	
	@OneToOne(mappedBy = "locacaoImovel", optional = true)
	private Cobranca cobranca;
	
	@ManyToOne
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;
	
	public LocacaoImovel() {
	}

	public LocacaoImovel(Long id, Integer quantidadeDiarias, Long valorPorDiaria, Imovel imovel) {
		this.id = id;
		this.quantidadeDiarias = quantidadeDiarias;
		this.imovel = imovel;
		this.valorPorDiaria = valorPorDiaria;
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

	public Long getValorPorDiaria() {
		return valorPorDiaria;
	}
	
	public void setValorPorDiaria(Long valorPorDiaria) {
		this.valorPorDiaria = valorPorDiaria;
	}
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public Cobranca getCobranca() {
		return cobranca;
	}
	
	public void setCobranca(Cobranca cobranca) {
		this.cobranca = cobranca;
	}
	
	
}
