package com.testing.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Album;
import com.testing.music.domain.Composition;

/**
 * Интерфейс репозитория для <code>Album</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface AlbumRepository extends CrudRepository<Album, Integer> {

	String Q_GET_BY_COMPOSITION = "SELECT a FROM Album a INNER JOIN a.tracks t WHERE a.singer != null and t.composition = :composition";

	@Query(Q_GET_BY_COMPOSITION)
	List<Album> getByComposition(@Param("composition") Composition composition);

}
