package com.testing.music.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.music.domain.Person;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Integer> {

	List<Person> findByName(String name);

}
