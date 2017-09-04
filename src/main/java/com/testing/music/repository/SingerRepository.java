package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Singer;

/**
 * Интерфейс репозитория для <code>Singer</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface SingerRepository extends CrudRepository<Singer, Integer> {

}
