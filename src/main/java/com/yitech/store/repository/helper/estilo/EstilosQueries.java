package com.yitech.store.repository.helper.estilo;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yitech.store.model.Estilo;
import com.yitech.store.repository.filter.EstiloFilter;



public interface EstilosQueries {

	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);

}

