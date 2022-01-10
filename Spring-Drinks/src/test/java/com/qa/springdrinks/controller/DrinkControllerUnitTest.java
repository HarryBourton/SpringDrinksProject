package com.qa.springdrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.fasterxml.jackson.core.JsonProcessingException;
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
	
	@Test
	public void testReadById() throws Exception {
		Drink entry = new Drink(3, "Pepsi Max", "PepsiCo.", 2000, 330, true, false);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.getById(3)).thenReturn(entry);
		
		mvc.perform(get("/drink/readById/3").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
		.andExpect(status().isOk()).andExpect(content().json(entryAsJSON));		
	}
	
	@Test
	public void testUpdate() throws Exception {
		Drink entry = new Drink(4, "Pepsi Ginger", "PepsiCo.", 2016, 1000, true, false);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.update(4, entry)).thenReturn(entry);
		
		mvc.perform(put("/drink/update/4").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
		.andExpect(status().isAccepted()).andExpect(content().json(entryAsJSON));	
	}
	
	@Test
	public void testDelete() throws Exception {
		Drink entry = new Drink(7, "Pepsi Caffeine-Free", "PepsiCo.", 2016, 330, true, false);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.delete(7)).thenReturn(true);
		
		mvc.perform(delete("/drink/delete/7").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
		.andExpect(status().isNoContent());
		
		Mockito.when(this.service.delete(8)).thenReturn(false);
		
		mvc.perform(delete("/drink/delete/8").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
		.andExpect(status().isNotFound());
		
	}

}
