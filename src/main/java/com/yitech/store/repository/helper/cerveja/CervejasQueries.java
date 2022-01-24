package com.yitech.store.repository.helper.cerveja;



import java.util.List;

import com.yitech.store.dto.Produtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yitech.store.dto.CervejaDTO;
import com.yitech.store.dto.ValorItensEstoque;
import com.yitech.store.model.Cerveja;
import com.yitech.store.repository.filter.CervejaFilter;

public interface CervejasQueries {

	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);

	public List<CervejaDTO> porSkuOuNome(String skuOuNome);

	public ValorItensEstoque valorItensEstoque();

}
