package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Album;

@Transactional
public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
