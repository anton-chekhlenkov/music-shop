package com.testing.music.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.music.domain.Album;
import com.testing.music.service.AlbumService;

/**
 * Контроллер для хранимых объектов <code>Album</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@RestController
@RequestMapping("/album")
@CrossOrigin(origins = "*")
public class AlbumController {

	private final AlbumService albums;

	@Autowired
	public AlbumController(final AlbumService albums) {
		this.albums = albums;
	}

	@GetMapping("/")
	public ResponseEntity<List<Album>> getAll() {
		return new ResponseEntity(this.albums.getAll(), HttpStatus.OK);
	}

	@GetMapping("/byCompositionId/{compositionId}")
	public ResponseEntity<List<Album>> getSingersByComposition(
			@PathVariable int compositionId) {
		return new ResponseEntity(this.albums.getByCompositionId(compositionId),
				HttpStatus.OK);
	}

}
