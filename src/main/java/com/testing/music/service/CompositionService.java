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

	List<Composition> getAll();

	List<Composition> getByComposerId(int composerId);

	List<Composition> getByWriterId(int writerId);

	List<Composition> getBySingerId(int singerId);

}
