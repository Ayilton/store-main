package com.yitech.store.repository.helper.cidade;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yitech.store.model.Cidade;
import com.yitech.store.repository.filter.CidadeFilter;

public interface CidadesQueries {

	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);
	
}
