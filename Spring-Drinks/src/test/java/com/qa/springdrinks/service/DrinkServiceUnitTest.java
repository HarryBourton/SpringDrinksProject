package com.qa.springdrinks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springdrinks.domain.Drink;
import com.qa.springdrinks.repo.DrinkRepo;

@SpringBootTest
public class DrinkServiceUnitTest {
	
	@Autowired
	private DrinkService service;
	
	@MockBean
	private DrinkRepo repo;
	
	@Test
	public void createTest() {
		Drink input = new Drink("Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 330, true, false);
		Drink output = new Drink(1, "Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 330, true, false);
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}


}
