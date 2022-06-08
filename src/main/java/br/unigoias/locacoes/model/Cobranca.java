package br.unigoias.locacoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cobranca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valorPrincipal;
	
	private Double valorImposto;
	
	private Double valorPagamento;
	
	@OneToOne
	@JoinColumn(name = "locacao_imovel_id")
	@JsonIgnore
	private LocacaoImovel locacaoImovel;
	
	public Cobranca() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorPrincipal() {
		return valorPrincipal;
	}

	public void setValorPrincipal(Double valorPrincipal) {
		this.valorPrincipal = valorPrincipal;
	}

	public Double getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(Double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public LocacaoImovel getLocacaoImovel() {
		return locacaoImovel;
	}

	public void setLocacaoImovel(LocacaoImovel locacaoImovel) {
		this.locacaoImovel = locacaoImovel;
	}
	
	
	
}
