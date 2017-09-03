package com.testing.music.service;

import java.util.List;

import com.testing.music.domain.Person;

public interface PersonService {

	List<Person> getByName(String name);

	List<Person> getAll();

	Person create(Person person);

}
