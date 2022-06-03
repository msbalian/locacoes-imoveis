package br.unigoias.locacoes.model.dto;

import br.unigoias.locacoes.model.LocacaoImovel;

public class LocacaoImovelDTO {

	public Long id;
	
	public Integer quantidadeDiarias;
	
	public Double valorPorDiaria;
	
	public Long imovelId;
	
	public Long cobrancaId;

	public LocacaoImovelDTO() {
	}

	public LocacaoImovelDTO(Long id, Integer quantidadeDiarias, Double valorPorDiaria, Long imovelId) {
		this.id = id;
		this.quantidadeDiarias = quantidadeDiarias;
		this.valorPorDiaria = valorPorDiaria;
		this.imovelId = imovelId;
	}


	public LocacaoImovelDTO(LocacaoImovel locacaoImovel) {
		this.id = locacaoImovel.getId();
		this.quantidadeDiarias = locacaoImovel.getQuantidadeDiarias();
		this.valorPorDiaria = locacaoImovel.getValorPorDiaria();
		this.imovelId = locacaoImovel.getImovel().getId();
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

	public Double getValorPorDiaria() {
		return valorPorDiaria;
	}

	public void setValorPorDiaria(Double valorPorDiaria) {
		this.valorPorDiaria = valorPorDiaria;
	}

	public Long getImovelId() {
		return imovelId;
	}

	public void setImovelId(Long imovelId) {
		this.imovelId = imovelId;
	}

	public Long getCobrancaId() {
		return cobrancaId;
	}

	public void setCobrancaId(Long cobrancaId) {
		this.cobrancaId = cobrancaId;
	}
	
	
	
	
}
