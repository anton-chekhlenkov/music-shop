package com.testing.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;
import com.testing.music.domain.Singer;
import com.testing.music.repository.SingerRepository;

/**
 * Реализация сервиса для работы с сущностями <code>Singer</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Service
public class SingerServiceImpl implements SingerService {

	private final SingerRepository repository;

	@Autowired
	public SingerServiceImpl(final SingerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Singer> getAll() {
		return Lists.newArrayList(this.repository.findAll());
	}

	@Override
	public List<Singer> getByComposition(Composition composition) {
		return this.repository.getByComposition(composition);
	}

	@Override
	public List<Singer> getGroupsByPerson(Person person) {
		return this.repository.getGroupsByPerson(person);
	}

}
