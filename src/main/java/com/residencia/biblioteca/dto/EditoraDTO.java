package com.residencia.biblioteca.dto;

public class EditoraDTO {
	private Integer codigoEditora;
	private String nome;
	private String imagemNome;
	private String imagemFileName;
	private String imagemUrl;

	public EditoraDTO() {
	}

	public EditoraDTO(Integer codigoEditora, String nome, String imagemNome, String imagemFileName, String imagemUrl) {
		this.codigoEditora = codigoEditora;
		this.nome = nome;
		this.imagemNome = imagemNome;
		this.imagemFileName = imagemFileName;
		this.imagemUrl = imagemUrl;
	}

	public Integer getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFileName() {
		return imagemFileName;
	}

	public void setImagemFileName(String imagemFileName) {
		this.imagemFileName = imagemFileName;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	@Override
	public String toString() {
		return "EditoraDTO [codigoEditora=" + codigoEditora + ", nome=" + nome + ", imagemNome=" + imagemNome
				+ ", imagemFileName=" + imagemFileName + ", imagemUrl=" + imagemUrl + "]";
	}

}