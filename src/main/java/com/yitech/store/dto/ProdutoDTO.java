package com.yitech.store.dto;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;



public class ProdutoDTO {

	private Long codigo;
	private String descricao;
	private String nome;
	private BigDecimal valorDeAquisicao;
	private String foto;
	private String urlThumbnailFoto;

	
	
	public ProdutoDTO(Long codigo, String descricao, String nome, BigDecimal valorDeAquisicao, String foto,
			String urlThumbnailFoto) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome = nome;
		this.valorDeAquisicao = valorDeAquisicao;
		this.urlThumbnailFoto = urlThumbnailFoto;
		this.foto = StringUtils.isEmpty(foto) ? "produto-mock.png" : foto;
	}



	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public BigDecimal getValorDeAquisicao() {
		return valorDeAquisicao;
	}



	public void setValorDeAquisicao(BigDecimal valorDeAquisicao) {
		this.valorDeAquisicao = valorDeAquisicao;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public String getUrlThumbnailFoto() {
		return urlThumbnailFoto;
	}



	public void setUrlThumbnailFoto(String urlThumbnailFoto) {
		this.urlThumbnailFoto = urlThumbnailFoto;
	}

	
	
}
