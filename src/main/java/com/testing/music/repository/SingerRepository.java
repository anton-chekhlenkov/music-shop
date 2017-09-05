package com.testing.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;
import com.testing.music.domain.Singer;

/**
 * Интерфейс репозитория для <code>Singer</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface SingerRepository extends CrudRepository<Singer, Integer> {

	String Q_GET_BY_COMPOSITION = "SELECT s FROM Singer s INNER JOIN s.tracks t WHERE t.composition = :composition";
	String Q_GET_GROUPS_BY_PERSON = "SELECT s FROM Singer s INNER JOIN s.singerStructure ss WHERE s.singerType = 'GROUP' and ss.person = :person";

	@Query(Q_GET_BY_COMPOSITION)
	List<Singer> getByComposition(@Param("composition") Composition composition);

	@Query(Q_GET_GROUPS_BY_PERSON)
	List<Singer> getGroupsByPerson(@Param("person") Person person);

}
