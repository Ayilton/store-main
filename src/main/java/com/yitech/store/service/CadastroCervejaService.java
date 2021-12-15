package com.yitech.store.service;


import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yitech.store.model.Cerveja;
import com.yitech.store.repository.Cervejas;
import com.yitech.store.service.exception.ImpossivelExcluirEntidadeException;
import com.yitech.store.storage.FotoStorage;

@Service
public class CadastroCervejaService {

		@Autowired
		private Cervejas cervejas;
		
		@Autowired
		private FotoStorage fotoStorage;
		
		@Transactional
		public void salvar(Cerveja cerveja) {
			cervejas.save(cerveja);
		}
		
		@Transactional
		public void excluir(Cerveja cerveja) {
			try {
				String foto = cerveja.getFoto();
				cervejas.delete(cerveja);
				cervejas.flush();
				fotoStorage.excluir(foto);
			} catch (PersistenceException e) {
				throw new ImpossivelExcluirEntidadeException("Impossível apagar cerveja. Já foi usada em alguma venda.");
			}
		}
	
}
