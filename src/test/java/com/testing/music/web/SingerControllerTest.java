package com.testing.music.web;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.music.common.SingerType;
import com.testing.music.domain.Singer;
import com.testing.music.repository.SingerRepository;
import com.testing.music.service.SingerService;
import com.testing.music.web.SingerController;

@RunWith(SpringRunner.class)
@WebMvcTest(SingerController.class)
public class SingerControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private SingerService singers;

	@Mock
	private SingerRepository singersRepository;

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getAllSingers() throws Exception {

		List<Singer> list = Collections.singletonList(
				new Singer(2, "Singer 2 (group)", SingerType.GROUP)
		);
		BDDMockito.given(this.singers.getAll()).willReturn(list);

		this.mvc.perform(
				MockMvcRequestBuilders.get("/singer/").accept(MediaType.APPLICATION_JSON_UTF8)
		).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(
				MockMvcResultMatchers.content().string(mapper.writeValueAsString(list))
		);

	}

}
