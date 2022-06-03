package br.unigoias.locacoes.model.dto;

import br.unigoias.locacoes.model.Cobranca;

public class CobrancaDTO {

	private Double valorPrincipal;
	
	private Double valorImposto;

	private Double ValorPagamento;
	
	private Long locacaoId;
	
	private String paisTributacao;
	
	public CobrancaDTO() {
	}

	public CobrancaDTO(Cobranca cobranca) {
		this.locacaoId = cobranca.getId();
		this.valorImposto = cobranca.getValorImposto();
		this.valorPrincipal = cobranca.getValorPrincipal();
		this.ValorPagamento = cobranca.getValorPagamento();
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
		return ValorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		ValorPagamento = valorPagamento;
	}

	public Long getLocacaoId() {
		return locacaoId;
	}

	public void setLocacaoId(Long locacaoId) {
		this.locacaoId = locacaoId;
	}

	public String getPaisTributacao() {
		return paisTributacao;
	}

	public void setPaisTributacao(String paisTributacao) {
		this.paisTributacao = paisTributacao;
	}

	
	
}
