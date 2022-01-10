package com.qa.springdrinks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.springdrinks.domain.Drink;
import com.qa.springdrinks.repo.DrinkRepo;

@Service
public class DrinkService implements DrinkServiceInterface<Drink> {

	private DrinkRepo repo;

	// Constructor
	public DrinkService(DrinkRepo repo) {
		this.repo = repo;
	}

	@Override
	public Drink create(Drink t) {
		return this.repo.save(t);
	}

	@Override
	public List<Drink> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Drink getById(int id) {
		Optional<Drink> optionalDrink = this.repo.findById(id);
		if (optionalDrink.isPresent()) {
			return optionalDrink.get();
		}
		return null;
	}

	@Override
	public Drink update(int id, Drink t) {
		Optional<Drink> existingDrink = this.repo.findById(id);
		if (existingDrink.isPresent()) {
			Drink existing = existingDrink.get();
			existing.setContainsSugar(t.isContainsSugar());
			existing.setFizzy(t.isFizzy());
			existing.setManufacturer(t.getManufacturer());
			existing.setName(t.getName());
			existing.setVolume(t.getVolume());
			existing.setYearIntroduced(t.getYearIntroduced());

			return this.repo.saveAndFlush(existing);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
