package com.qa.springdrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springdrinks.domain.Drink;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:drink-schema.sql", "classpath:drink-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

public class DrinkControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 330, true, false);
		Drink result = new Drink(2, "Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 330, true, false);
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(post("/drink/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
		.andExpect(status().isCreated()).andExpect(content().json(resultAsJSON));
	}

}
