package com.testing.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.testing.music.domain.Album;
import com.testing.music.repository.AlbumRepository;

/**
 * Реализация сервиса для работы с сущностями <code>Album</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@Service
public class AlbumServiceImpl implements AlbumService {

	private final AlbumRepository repository;

	@Autowired
	public AlbumServiceImpl(final AlbumRepository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Album> getAll() {
		return Lists.newArrayList(this.repository.findAll());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Album> getByCompositionId(int compositionId) {
		return this.repository.getByCompositionId(compositionId);
	}

}
