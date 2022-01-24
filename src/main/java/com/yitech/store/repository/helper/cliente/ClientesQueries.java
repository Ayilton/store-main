package com.yitech.store.repository.helper.cliente;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yitech.store.model.Cliente;
import com.yitech.store.repository.filter.ClienteFilter;

public interface ClientesQueries {

	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);

}
