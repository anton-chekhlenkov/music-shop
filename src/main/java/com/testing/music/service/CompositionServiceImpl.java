package com.testing.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.testing.music.domain.Composition;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Composition> getAll() {
		return Lists.newArrayList(this.repository.findAll());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Composition> getByComposerId(int composerId) {
		return this.repository.findByComposerId(composerId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Composition> getByWriterId(int writerId) {
		return this.repository.findByWriterId(writerId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Composition> getBySingerId(int singerId) {
		return this.repository.getBySingerId(singerId);
	}

}
