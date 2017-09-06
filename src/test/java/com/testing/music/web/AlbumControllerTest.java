package com.testing.music.web;

import java.util.Calendar;
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
import com.testing.music.common.SingerType;
import com.testing.music.domain.Album;
import com.testing.music.domain.Singer;
import com.testing.music.service.AlbumService;
import com.testing.music.web.AlbumController;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AlbumService albums;

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getAllAlbums() throws Exception {

		List<Album> list = Collections.singletonList(
				new Album(1, "Album 1", new Singer(1, "Singer 1 (solist)", SingerType.PERSON), Calendar.getInstance())
		);
		BDDMockito.given(this.albums.getAll()).willReturn(list);

		this.mvc.perform(
				MockMvcRequestBuilders.get("/album/").accept(MediaType.APPLICATION_JSON_UTF8)
		).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(
				MockMvcResultMatchers.content().string(mapper.writeValueAsString(list))
		);

	}

}
