package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Album;

/**
 * Интерфейс репозитория для <code>Album</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Transactional
public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
