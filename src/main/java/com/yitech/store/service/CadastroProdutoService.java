package com.yitech.store.service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yitech.store.model.Produto;
import com.yitech.store.repository.Produtos;
import com.yitech.store.service.exception.ImpossivelExcluirEntidadeException;
import com.yitech.store.storage.FotoStorage;

@Service
public class CadastroProdutoService {

	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@Transactional
	public void salvar(Produto produto) {
		produtos.save(produto);
	}
	
	@Transactional
	public void excluir(Produto produto) {
		try {
			String foto = produto.getFoto();
			produtos.delete(produto);
			produtos.flush();
			fotoStorage.excluir(foto);
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar cerveja. Já foi usada em alguma venda.");
		}
	}
	
	
}
