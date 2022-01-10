package com.qa.springdrinks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public void testCreate() {
		Drink input = new Drink("Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 330, true, false);
		Drink output = new Drink(1, "Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 330, true, false);

		Mockito.when(this.repo.save(input)).thenReturn(output);

		assertEquals(output, this.service.create(input));

		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}

	@Test
	public void testGetAll() {
		Drink drinkGetAll = new Drink(1, "Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 1500, true, false);
		List<Drink> list = new ArrayList<Drink>();
		list.add(drinkGetAll);

		Mockito.when(this.repo.findAll()).thenReturn(list);

		assertEquals(list, this.service.getAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testGetById() {
		Optional<Drink> optionalDrink = Optional
				.of(new Drink(4, "Coca-Cola Zero Sugar", "The Coca-Cola Company", 2005, 2000, true, false));

		Mockito.when(this.repo.findById(4)).thenReturn(optionalDrink);

		assertEquals(optionalDrink, Optional.of(this.service.getById(4)));

	}

}
