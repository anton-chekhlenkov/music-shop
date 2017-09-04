package com.testing.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.testing.music.domain.Person;
import com.testing.music.repository.PersonRepository;

/**
 * Реализация сервиса для работы с сущностями <code>Person</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository repository;

	@Autowired
	public PersonServiceImpl(final PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Person> getByName(String name) {
		return this.repository.findByName(name);
	}

	@Override
	public List<Person> getAll() {
		return Lists.newArrayList(this.repository.findAll());
	}

	@Override
	public Person create(Person person) {
		return this.repository.save(person);
	}
}
