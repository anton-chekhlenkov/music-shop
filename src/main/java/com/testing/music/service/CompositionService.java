package com.testing.music.service;

import java.util.List;

import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;
import com.testing.music.domain.Singer;

/**
 * Интерфейс сервиса для работы с сущностями <code>Composition</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
public interface CompositionService {

	List<Composition> getAll();

	List<Composition> getByComposer(Person composer);

	List<Composition> getByWriter(Person composer);

	List<Composition> getBySinger(Singer composer);

}
