package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Singer;

@Transactional
public interface SingerRepository extends CrudRepository<Singer, Integer> {

}
