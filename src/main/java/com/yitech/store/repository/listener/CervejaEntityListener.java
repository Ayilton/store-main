package com.yitech.store.repository.listener;



import javax.persistence.PostLoad;

import com.yitech.store.StoreApplication;
import com.yitech.store.model.Cerveja;
import com.yitech.store.storage.FotoStorage;

public class CervejaEntityListener {

	@PostLoad
	public void postLoad(final Cerveja cerveja) {
		FotoStorage fotoStorage = StoreApplication.getBean (FotoStorage.class);

		cerveja.setUrlFoto(fotoStorage.getUrl(cerveja.getFotoOuMock()));
		cerveja.setUrlThumbnailFoto(fotoStorage.getUrl(FotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOuMock()));
	}

}
