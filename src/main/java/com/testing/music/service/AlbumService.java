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

	/**
	 * Получить полный список альбомов (включая сборники)
	 * 
	 * @return
	 */
	List<Album> getAll();

	/**
	 * Найти все альбомы на которых издавалась заданная композиция
	 * 
	 * @param compositionId
	 * @return
	 */
	List<Album> getByCompositionId(int compositionId);

}
