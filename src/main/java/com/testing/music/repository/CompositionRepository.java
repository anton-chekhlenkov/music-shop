package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Composition;

@Transactional
public interface CompositionRepository extends CrudRepository<Composition, Integer> {

}
