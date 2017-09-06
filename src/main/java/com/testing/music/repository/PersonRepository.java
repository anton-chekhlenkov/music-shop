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

	String Q_GET_ALL_COMPOSERS = "SELECT p FROM Person p INNER JOIN p.composedCompositions";

	String Q_GET_ALL_WRITERS = "SELECT p FROM Person p INNER JOIN p.writedCompositions";

	@Query(Q_GET_ALL_COMPOSERS)
	List<Person> getAllComposers();

	@Query(Q_GET_ALL_WRITERS)
	List<Person> getAllWriters();

}
