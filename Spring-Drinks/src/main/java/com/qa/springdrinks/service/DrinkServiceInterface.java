package com.qa.springdrinks.service;

import java.util.List;

public interface DrinkServiceInterface<T> {
	//Create
	T create(T t);
	
	//Read all
	List <T> getAll(); 
	
	//Read by id
	T getById(int id);
	
	//Update(PUT)
	T update(int id, T t);
	
	//Delete
	boolean delete(int id);

}
