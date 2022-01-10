package com.qa.springdrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springdrinks.domain.Drink;
import com.qa.springdrinks.service.DrinkService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DrinkControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private DrinkService service;

	@Test
	public void testCreate() throws Exception {
		Drink entry = new Drink("Pepsi", "PepsiCo.", 1893, 500, true, true);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.create(entry)).thenReturn(entry);

		mvc.perform(post("/drink/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void testReadAll() throws Exception {
		Drink entry = new Drink("Pepsi Cherry", "PepsiCo.", 1893, 1500, true, true);
		List<Drink> list = new ArrayList<Drink>();
		list.add(entry);
		String entryAsJSON = this.mapper.writeValueAsString(list);
		
		Mockito.when(this.service.getAll()).thenReturn(list);
		
		mvc.perform(get("/drink/readAll").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
		.andExpect(status().isOk()).andExpect(content().json(entryAsJSON));
	}

}
