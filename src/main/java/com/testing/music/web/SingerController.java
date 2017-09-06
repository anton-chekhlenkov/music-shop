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

import com.testing.music.domain.Singer;
import com.testing.music.service.SingerService;

/**
 * Контроллер для хранимых объектов <code>Singer</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@RestController
@RequestMapping("/singer")
@CrossOrigin(origins = "*")
public class SingerController {

	private final SingerService singers;

	@Autowired
	public SingerController(final SingerService singers) {
		this.singers = singers;
	}

	@GetMapping("/")
	public ResponseEntity<List<Singer>> getAll() {
		return new ResponseEntity<List<Singer>>(this.singers.getAll(),
				HttpStatus.OK);
	}

	@GetMapping("/byCompositionId/{compositionId}")
	public ResponseEntity<List<Singer>> getSingersByComposition(
			@PathVariable int compositionId) {
		return new ResponseEntity<List<Singer>>(
				this.singers.getByCompositionId(compositionId), HttpStatus.OK);
	}

	@GetMapping("/groupsByPersonId/{personId}")
	public ResponseEntity<List<Singer>> getGroupsByPerson(
			@PathVariable int personId) {
		return new ResponseEntity<List<Singer>>(
				this.singers.getGroupsByPersonId(personId), HttpStatus.OK);
	}

}
