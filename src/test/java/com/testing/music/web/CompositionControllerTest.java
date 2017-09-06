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
import com.testing.music.domain.Composition;
import com.testing.music.domain.Person;
import com.testing.music.service.CompositionService;
import com.testing.music.web.CompositionController;

@RunWith(SpringRunner.class)
@WebMvcTest(CompositionController.class)
public class CompositionControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CompositionService compositions;

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getAllCompositions() throws Exception {

		List<Composition> list = Collections.singletonList(
			new Composition(1, "Composition 1", new Person(1, "Writer 1"), new Person(2, "Composer 1"))		
		);
		BDDMockito.given(this.compositions.getAll()).willReturn(list);

		this.mvc.perform(
				MockMvcRequestBuilders.get("/composition/").accept(MediaType.APPLICATION_JSON_UTF8)
		).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(
				MockMvcResultMatchers.content().string(mapper.writeValueAsString(list))
		);

	}

}
