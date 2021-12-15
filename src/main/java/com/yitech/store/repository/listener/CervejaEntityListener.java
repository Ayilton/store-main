package com.yitech.store.repository.listener;



import javax.persistence.PostLoad;

import com.yitech.store.model.Cerveja;

public class CervejaEntityListener {

	@PostLoad
	public void postLoad(final Cerveja cerveja) {
		/*FotoStorage fotoStorage = BrewerApplication.getBean(FotoStorage.class);*/
	/**	FotoStorage fotoStorage = null;
		
		cerveja.setUrlFoto(fotoStorage.getUrl(cerveja.getFotoOuMock()));
		cerveja.setUrlThumbnailFoto(fotoStorage.getUrl(FotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOuMock()));*/
	}
	
}
