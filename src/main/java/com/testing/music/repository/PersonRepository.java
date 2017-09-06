package com.testing.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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

	/**
	 * Получить всех композиторов
	 * 
	 * @return
	 */
	@Query("SELECT p FROM Person p INNER JOIN p.composedCompositions")
	List<Person> getAllComposers();

	/**
	 * Получить всех авторов текстов
	 * 
	 * @return
	 */
	@Query("SELECT p FROM Person p INNER JOIN p.writedCompositions")
	List<Person> getAllWriters();

}
