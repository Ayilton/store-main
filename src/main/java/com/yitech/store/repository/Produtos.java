package com.yitech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yitech.store.model.Produto;
import com.yitech.store.repository.helper.produto.ProdutosQueries;

public interface Produtos extends JpaRepository<Produto, Long>, ProdutosQueries {

}
