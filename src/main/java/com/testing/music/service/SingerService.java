package com.testing.music.service;

import java.util.List;

import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;
import com.testing.music.domain.Singer;

/**
 * Интерфейс сервиса для работы с сущностями <code>Singer</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
public interface SingerService {

	List<Singer> getAll();

	List<Singer> getByComposition(Composition composition);

	List<Singer> getGroupsByPerson(Person person);

}
