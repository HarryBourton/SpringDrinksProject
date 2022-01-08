package com.qa.springdrinks.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DrinkTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
	}

	@Test
	public void noIdConstructor() {
		Drink drink = new Drink("J2O Orange & Passionfruit", "Britvic plc", 1998, 275, false, true);

		assertNotNull(drink.getName());
		assertNotNull(drink.getManufacturer());
		assertNotNull(drink.getYearIntroduced());
		assertNotNull(drink.getVolume());
		assertNotNull(drink.isFizzy());
		assertNotNull(drink.isContainsSugar());

		assertEquals(drink.getName(), "J2O Orange & Passionfruit");
		assertEquals(drink.getManufacturer(), "Britvic plc");
		assertEquals(drink.getYearIntroduced(), 1998);
		assertEquals(drink.getVolume(), 275);
		assertEquals(drink.isFizzy(), false);
		assertEquals(drink.isContainsSugar(), true);
	}

	@Test
	public void idConstructor() {
		Drink drink = new Drink(1, "J2O Orange & Passionfruit", "Britvic plc", 1998, 275, false, true);

		assertNotNull(drink.getId());
		assertNotNull(drink.getName());
		assertNotNull(drink.getManufacturer());
		assertNotNull(drink.getYearIntroduced());
		assertNotNull(drink.getVolume());
		assertNotNull(drink.isFizzy());
		assertNotNull(drink.isContainsSugar());

		assertEquals(drink.getId(), 1);
		assertEquals(drink.getName(), "J2O Orange & Passionfruit");
		assertEquals(drink.getManufacturer(), "Britvic plc");
		assertEquals(drink.getYearIntroduced(), 1998);
		assertEquals(drink.getVolume(), 275);
		assertEquals(drink.isFizzy(), false);
		assertEquals(drink.isContainsSugar(), true);
	}

	@Test
	public void settersTest() {
		Drink drink = new Drink();

		drink.setName("Pepsi");
		drink.setManufacturer("PepsiCo.");
		drink.setYearIntroduced(1893);
		drink.setVolume(330);
		drink.setFizzy(true);
		drink.setContainsSugar(true);

		assertNotNull(drink.getName());
		assertNotNull(drink.getManufacturer());
		assertNotNull(drink.getYearIntroduced());
		assertNotNull(drink.getVolume());
		assertNotNull(drink.isFizzy());
		assertNotNull(drink.isContainsSugar());

		assertEquals(drink.getName(), "Pepsi");
		assertEquals(drink.getManufacturer(), "PepsiCo.");
		assertEquals(drink.getYearIntroduced(), 1893);
		assertEquals(drink.getVolume(), 330);
		assertEquals(drink.isFizzy(), true);
		assertEquals(drink.isContainsSugar(), true);

	}

}
