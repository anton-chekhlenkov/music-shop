package com.testing.music.service;

import java.util.List;

import com.testing.music.domain.Person;

/**
 * Интерфейс сервиса для работы с сущностями <code>Person</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
public interface PersonService {

	/**
	 * Получить список всех людей
	 * 
	 * @return
	 */
	List<Person> getAll();

	/**
	 * Получить список всех композиторов
	 * 
	 * @return
	 */
	List<Person> getAllComposers();

	/**
	 * Получить список всех авторов текста
	 * 
	 * @return
	 */
	List<Person> getAllWriters();

}
