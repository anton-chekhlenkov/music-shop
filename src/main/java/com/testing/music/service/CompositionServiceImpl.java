package com.testing.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;
import com.testing.music.domain.Singer;
import com.testing.music.repository.CompositionRepository;

/**
 * Реализация сервиса для работы с сущностями <code>Composition</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Service
public class CompositionServiceImpl implements CompositionService {

	private final CompositionRepository repository;

	@Autowired
	public CompositionServiceImpl(final CompositionRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Composition> getAll() {
		return Lists.newArrayList(this.repository.findAll());
	}

	@Override
	public List<Composition> getByComposer(Person composer) {
		return this.repository.findByComposer(composer);
	}

	@Override
	public List<Composition> getByWriter(Person writer) {
		return this.repository.findByWriter(writer);
	}

	@Override
	public List<Composition> getBySinger(Singer singer) {
		return this.repository.getBySinger(singer.getId());
	}

}
