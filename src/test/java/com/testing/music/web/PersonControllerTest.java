package com.testing.music.web.tests;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.music.domain.Person;
import com.testing.music.service.PersonService;
import com.testing.music.web.PersonController;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonService persons;

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getAllPersons() throws Exception {

		List<Person> list = Collections.singletonList(
				new Person(1, "Person 1")
		);
		BDDMockito.given(this.persons.getAll()).willReturn(list);

		this.mvc.perform(
				MockMvcRequestBuilders.get("/person/").accept(MediaType.APPLICATION_JSON_UTF8)
		).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(
				MockMvcResultMatchers.content().string(mapper.writeValueAsString(list))
		);

	}

	@Test
	public void getAllWriters() throws Exception {

		List<Person> list = Collections.singletonList(
				new Person(1, "Person 1")
		);
		BDDMockito.given(this.persons.getAllWriters()).willReturn(list);

		this.mvc.perform(
				MockMvcRequestBuilders.get("/person/writers/").accept(MediaType.APPLICATION_JSON_UTF8)
		).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(
				MockMvcResultMatchers.content().string(mapper.writeValueAsString(list))
		);

	}

	@Test
	public void getAllComposers() throws Exception {

		List<Person> list = Collections.singletonList(
				new Person(1, "Person 1")
		);
		BDDMockito.given(this.persons.getAllComposers()).willReturn(list);

		this.mvc.perform(
				MockMvcRequestBuilders.get("/person/composers/").accept(MediaType.APPLICATION_JSON_UTF8)
		).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(
				MockMvcResultMatchers.content().string(mapper.writeValueAsString(list))
		);

	}

}
