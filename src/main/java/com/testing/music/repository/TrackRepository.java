package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Track;

@Transactional
public interface TrackRepository extends CrudRepository<Track, Integer> {

}
