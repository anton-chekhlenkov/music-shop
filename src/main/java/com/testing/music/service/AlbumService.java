package com.testing.music.service;

import java.util.List;

import com.testing.music.domain.Album;

/**
 * Интерфейс сервиса для работы с сущностями <code>Album</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
public interface AlbumService {

	List<Album> getAll();

	List<Album> getByCompositionId(int compositionId);

}
