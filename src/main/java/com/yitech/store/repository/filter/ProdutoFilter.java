package com.yitech.store.repository.filter;



import java.math.BigDecimal;

import com.yitech.store.model.Categoria;

public class ProdutoFilter {

	private String descricao;
	private String nome;
	private BigDecimal valorDeAquisicao;
	private BigDecimal valorDeVenda;
	private BigDecimal lucro;
	private Integer quantidadeEstoque;
	private Categoria categoria;
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	public BigDecimal getValorDeVenda() {
		return valorDeVenda;
	}
	public void setValorDeVenda(BigDecimal valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}
	public BigDecimal getLucro() {
		return lucro;
	}
	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	
}
