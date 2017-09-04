package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Composition;

/**
 * Интерфейс репозитория для <code>Composition</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface CompositionRepository extends
		CrudRepository<Composition, Integer> {

}
