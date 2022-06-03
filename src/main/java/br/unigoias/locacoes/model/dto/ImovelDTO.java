package br.unigoias.locacoes.model.dto;

import br.unigoias.locacoes.model.Imovel;

public class ImovelDTO {

	private Long id;
	
	private String descricao;
	
	public ImovelDTO() {
	}

	public ImovelDTO(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public ImovelDTO(Imovel imovel) {
		this.id = imovel.getId();
		this.descricao = imovel.getDescricao();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	
}
