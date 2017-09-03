package com.testing.music.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.music.domain.Person;
import com.testing.music.service.PersonService;
import com.testing.music.web.forms.Error;
import com.testing.music.web.forms.Result;
import com.testing.music.web.forms.Success;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*")
public class PersonController {

	private final PersonService persons;

	@Autowired
	public PersonController(final PersonService persons) {
		this.persons = persons;
	}

	@PostMapping("/")
	public Result apply(@RequestBody Person person) {
		Result res = null;
		try {
			res = new Success<Person>(this.persons.create(person));
		} catch (Exception e) {
			res = new Error("Error: " + e.getMessage());
		}
		return res;
	}

	@GetMapping("/")
	public List<Person> getAll() {
		return this.persons.getAll();
	}

	@GetMapping("/{name}")
	public List<Person> findByName(@PathVariable String name) {
		return this.persons.getByName(name);
	}

}
