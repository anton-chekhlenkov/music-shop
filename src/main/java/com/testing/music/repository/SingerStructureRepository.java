package com.testing.music.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.SingerStructure;

@Transactional
public interface SingerStructureRepository extends CrudRepository<SingerStructure, Integer> {

}