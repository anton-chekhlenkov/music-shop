package com.testing.music.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Import(TestDataSourceConfig.class)
public class MainLogicTest {

	private static final String SINGER_BY_COMPOSITION_CORRECT_RESPONSE = "[{\"id\":1,\"name\":\"solist - Person 1\",\"singerType\":\"PERSON\"},{\"id\":12,\"name\":\"group - Persons 14, 15, 16\",\"singerType\":\"GROUP\"},{\"id\":3,\"name\":\"solist - Person 3\",\"singerType\":\"PERSON\"},{\"id\":13,\"name\":\"group - Persons 17, 18, 19\",\"singerType\":\"GROUP\"}]";
	private static final String SINGER_GROUPS_BY_PERSON_CORRECT_RESPONSE = "[{\"id\":11,\"name\":\"group - Persons 11, 12, 13\",\"singerType\":\"GROUP\"},{\"id\":16,\"name\":\"group - Persons 12, 15\",\"singerType\":\"GROUP\"}]";
	private static final String ALBUM_BY_COMPOSITION_CORRECT_RESPONSE = "[{\"id\":3,\"name\":\"album 3\",\"singer\":{\"id\":11,\"name\":\"group - Persons 11, 12, 13\",\"singerType\":\"GROUP\"},\"releaseDate\":1501707600000}]";
	private static final String COMPOSITION_BY_COMPOSER_CORRECT_RESPONSE = "[{\"id\":5,\"name\":\"composition 5\",\"writer\":{\"id\":5,\"name\":\"Person 5\"},\"composer\":{\"id\":15,\"name\":\"Person 15\"}}]";
	private static final String COMPOSITION_BY_WRITER_CORRECT_RESPONSE = "[{\"id\":15,\"name\":\"composition 15\",\"writer\":{\"id\":15,\"name\":\"Person 15\"},\"composer\":{\"id\":25,\"name\":\"Person 25\"}}]";
	private static final String COMPOSITION_BY_SINGER_CORRECT_RESPONSE = "[{\"id\":1,\"name\":\"composition 1\",\"writer\":{\"id\":1,\"name\":\"Person 1\"},\"composer\":{\"id\":11,\"name\":\"Person 11\"}},{\"id\":2,\"name\":\"composition 2\",\"writer\":{\"id\":2,\"name\":\"Person 2\"},\"composer\":{\"id\":12,\"name\":\"Person 12\"}},{\"id\":3,\"name\":\"composition 3\",\"writer\":{\"id\":3,\"name\":\"Person 3\"},\"composer\":{\"id\":13,\"name\":\"Person 13\"}},{\"id\":4,\"name\":\"composition 4\",\"writer\":{\"id\":4,\"name\":\"Person 4\"},\"composer\":{\"id\":14,\"name\":\"Person 14\"}},{\"id\":5,\"name\":\"composition 5\",\"writer\":{\"id\":5,\"name\":\"Person 5\"},\"composer\":{\"id\":15,\"name\":\"Person 15\"}},{\"id\":8,\"name\":\"composition 8\",\"writer\":{\"id\":8,\"name\":\"Person 8\"},\"composer\":{\"id\":18,\"name\":\"Person 18\"}},{\"id\":9,\"name\":\"composition 9\",\"writer\":{\"id\":9,\"name\":\"Person 9\"},\"composer\":{\"id\":19,\"name\":\"Person 19\"}},{\"id\":10,\"name\":\"composition 10\",\"writer\":{\"id\":10,\"name\":\"Person 10\"},\"composer\":{\"id\":20,\"name\":\"Person 20\"}}]";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getSingerByComposition() throws Exception {
	
		this.mockMvc.perform(
			MockMvcRequestBuilders.get("/singer/byCompositionId/1")
		.accept(
			MediaType.APPLICATION_JSON_UTF8))
		.andExpect(
			MockMvcResultMatchers.status().isOk())
		.andExpect(
			MockMvcResultMatchers.content().string(SINGER_BY_COMPOSITION_CORRECT_RESPONSE)
		);

	}
	
	@Test
	public void getSingerGroupsByPerson() throws Exception {
	
		this.mockMvc.perform(
			MockMvcRequestBuilders.get("/singer/groupsByPersonId/12")
		.accept(
			MediaType.APPLICATION_JSON_UTF8))
		.andExpect(
			MockMvcResultMatchers.status().isOk())
		.andExpect(
			MockMvcResultMatchers.content().string(SINGER_GROUPS_BY_PERSON_CORRECT_RESPONSE)
		);

	}
	
	@Test
	public void getAlbumByComposition() throws Exception {
	
		this.mockMvc.perform(
			MockMvcRequestBuilders.get("/album/byCompositionId/13")
		.accept(
			MediaType.APPLICATION_JSON_UTF8))
		.andExpect(
			MockMvcResultMatchers.status().isOk())
		.andExpect(
			MockMvcResultMatchers.content().string(ALBUM_BY_COMPOSITION_CORRECT_RESPONSE)
		);

	}
	
	@Test
	public void getCompositionByComposer() throws Exception {
	
		this.mockMvc.perform(
			MockMvcRequestBuilders.get("/composition/byComposer/15")
		.accept(
			MediaType.APPLICATION_JSON_UTF8))
		.andExpect(
			MockMvcResultMatchers.status().isOk())
		.andExpect(
			MockMvcResultMatchers.content().string(COMPOSITION_BY_COMPOSER_CORRECT_RESPONSE)
		);

	}
	
	@Test
	public void getCompositionByWriter() throws Exception {
	
		this.mockMvc.perform(
			MockMvcRequestBuilders.get("/composition/byWriter/15")
		.accept(
			MediaType.APPLICATION_JSON_UTF8))
		.andExpect(
			MockMvcResultMatchers.status().isOk())
		.andExpect(
			MockMvcResultMatchers.content().string(COMPOSITION_BY_WRITER_CORRECT_RESPONSE)
		);

	}
	
	@Test
	public void getCompositionBySinger() throws Exception {
	
		this.mockMvc.perform(
			MockMvcRequestBuilders.get("/composition/bySinger/13")
		.accept(
			MediaType.APPLICATION_JSON_UTF8))
		.andExpect(
			MockMvcResultMatchers.status().isOk())
		.andExpect(
			MockMvcResultMatchers.content().string(COMPOSITION_BY_SINGER_CORRECT_RESPONSE)
		);

	}

}
