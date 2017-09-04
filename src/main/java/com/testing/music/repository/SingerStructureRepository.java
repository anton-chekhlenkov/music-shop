package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.SingerStructure;

/**
 * Интерфейс репозитория для <code>SingerStructure</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface SingerStructureRepository extends
		CrudRepository<SingerStructure, Integer> {

}