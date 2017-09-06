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

import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;
import com.testing.music.service.CompositionService;

/**
 * Контроллер для хранимых объектов <code>Composition</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@RestController
@RequestMapping("/composition")
@CrossOrigin(origins = "*")
public class CompositionController {

	private final CompositionService compositions;

	@Autowired
	public CompositionController(final CompositionService compositions) {
		this.compositions = compositions;
	}

	@GetMapping("/")
	public ResponseEntity<List<Composition>> getAll() {
		return new ResponseEntity<List<Composition>>(
				this.compositions.getAll(), HttpStatus.OK);
	}

	@GetMapping("/byComposer/{composerId}")
	public ResponseEntity<List<Composition>> getByComposer(
			@PathVariable int composerId) {
		return new ResponseEntity<List<Composition>>(
				this.compositions.getByComposerId(composerId), HttpStatus.OK);
	}

	@GetMapping("/byWriter/{writerId}")
	public ResponseEntity<List<Composition>> getByWriter(
			@PathVariable int writerId) {
		return new ResponseEntity<List<Composition>>(
				this.compositions.getByWriterId(writerId), HttpStatus.OK);
	}

	@GetMapping("/bySinger/{singerId}")
	public ResponseEntity<List<Composition>> getBySinger(
			@PathVariable int singerId) {
		return new ResponseEntity<List<Composition>>(
				this.compositions.getBySingerId(singerId), HttpStatus.OK);
	}

}
