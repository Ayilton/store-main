package com.yitech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yitech.store.model.Venda;
import com.yitech.store.repository.helper.venda.VendasQueries;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries{

}
