package com.yitech.store.model;



public enum Sabor {

	ADOCICADA("Tipo1"),
	AMARGA("Tipo2"),
	FORTE("Tipo3"),
	FRUTADA("Tipo4"),
	SUAVE("Tipo5");

	private String descricao;

	Sabor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
