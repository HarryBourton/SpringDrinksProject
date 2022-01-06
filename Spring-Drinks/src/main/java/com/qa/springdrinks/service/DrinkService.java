package com.qa.springdrinks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springdrinks.domain.Drink;

@Service
public class DrinkService implements DrinkServiceInterface<Drink> {

	@Override
	public Drink create(Drink t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Drink> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Drink getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Drink update(int id, Drink t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
