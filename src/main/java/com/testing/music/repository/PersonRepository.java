package com.testing.music.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Person;

/**
 * Интерфейс репозитория для <code>Person</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface PersonRepository extends CrudRepository<Person, Integer> {

	List<Person> findByName(String name);

}
