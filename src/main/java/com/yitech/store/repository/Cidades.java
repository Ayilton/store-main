package com.yitech.store.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yitech.store.model.Cidade;
import com.yitech.store.model.Estado;
import com.yitech.store.repository.helper.cidade.CidadesQueries;


public interface Cidades extends JpaRepository<Cidade, Long>, CidadesQueries {

	public List<Cidade> findByEstadoCodigo(Long codigoEstado);

	public Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
	
}
