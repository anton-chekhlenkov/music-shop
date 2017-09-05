package com.testing.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;

/**
 * Интерфейс репозитория для <code>Composition</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface CompositionRepository extends
		CrudRepository<Composition, Integer> {

	String Q_GET_BY_SINGER = "SELECT c FROM Composition c INNER JOIN c.tracks t INNER JOIN t.singers ts WHERE ts.id = :singerId";

	List<Composition> findByComposer(Person composer);

	List<Composition> findByWriter(Person composer);

	@Query(Q_GET_BY_SINGER)
	List<Composition> getBySinger(@Param("singerId") int singerId);

}
