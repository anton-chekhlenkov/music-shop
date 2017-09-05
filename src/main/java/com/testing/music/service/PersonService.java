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

	List<Person> getAll();

}
