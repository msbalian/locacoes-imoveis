package br.unigoias.locacoes.model.dto;

public class PaisTributacaoDTO {

	private String nomePais;

	public PaisTributacaoDTO() {
	}

	public PaisTributacaoDTO(String nomePais) {
		this.nomePais = nomePais;
	}
	
	public String getNomePais() {
		return nomePais;
	}
	
	public void setNomePais(String nome) {
		this.nomePais = nome;
	}
	
	
	
}
