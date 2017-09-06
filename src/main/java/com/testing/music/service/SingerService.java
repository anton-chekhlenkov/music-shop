package com.testing.music.service;

import java.util.List;

import com.testing.music.domain.Singer;

/**
 * Интерфейс сервиса для работы с сущностями <code>Singer</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
public interface SingerService {

	/**
	 * Список всех исполнителей
	 * 
	 * @return
	 */
	List<Singer> getAll();

	/**
	 * Найти всех исполнителей которые исполняли композицию
	 * 
	 * @param compositionId
	 * @return
	 */
	List<Singer> getByCompositionId(int compositionId);

	/**
	 * Найти все группы в которых пел заданный исполнитель
	 * 
	 * @param personId
	 * @return
	 */
	List<Singer> getGroupsByPersonId(int personId);

}
