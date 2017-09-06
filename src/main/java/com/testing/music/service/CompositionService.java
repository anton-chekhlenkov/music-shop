package com.testing.music.service;

import java.util.List;

import com.testing.music.domain.Composition;

/**
 * Интерфейс сервиса для работы с сущностями <code>Composition</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
public interface CompositionService {

	/**
	 * Получить список всех композиций
	 * 
	 * @return
	 */
	List<Composition> getAll();

	/**
	 * Найти все композиции заданного композитора
	 * 
	 * @param composerId
	 * @return
	 */
	List<Composition> getByComposerId(int composerId);

	/**
	 * Найти все композиции заданного автора
	 * 
	 * @param writerId
	 * @return
	 */
	List<Composition> getByWriterId(int writerId);

	/**
	 * Найти все композиции заданного исполнителя
	 * 
	 * @param singerId
	 * @return
	 */
	List<Composition> getBySingerId(int singerId);

}
