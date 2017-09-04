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

import com.testing.music.domain.Person;
import com.testing.music.service.PersonService;

/**
 * Контроллер для хранимых объектов <code>Person</code>.
 * 
 * @author antonch
 * @since 02.09.2017
 */
@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*")
public class PersonController {

	private final PersonService persons;

	@Autowired
	public PersonController(final PersonService persons) {
		this.persons = persons;
	}

	@GetMapping("/")
	public ResponseEntity<List<Person>> getAll() {
		return new ResponseEntity(this.persons.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<List<Person>> findByName(@PathVariable String name) {
		return new ResponseEntity(this.persons.getByName(name), HttpStatus.OK);
	}

}
