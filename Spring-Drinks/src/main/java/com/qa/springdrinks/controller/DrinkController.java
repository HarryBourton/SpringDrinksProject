package com.qa.springdrinks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springdrinks.domain.Drink;
import com.qa.springdrinks.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {
	private DrinkService service;

	private DrinkController(DrinkService service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<Drink> createDrink(@RequestBody Drink t) {
		return new ResponseEntity<Drink>(this.service.create(t), HttpStatus.CREATED);

	}

	// Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Drink>> readAllDrinks() {
		return new ResponseEntity<List<Drink>>(this.service.getAll(), HttpStatus.OK);
	}

	// Read by id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Drink> readDrinkById(@PathVariable int id) {
		return new ResponseEntity<Drink>(this.service.getById(id), HttpStatus.OK);
	}

	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Drink> updateDrink(@PathVariable int id, @RequestBody Drink t) {
		return new ResponseEntity<Drink>(this.service.update(id, t), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteDrink(@PathVariable int id) {
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
