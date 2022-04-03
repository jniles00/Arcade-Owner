package com.jn.arcade.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	// Create - create object of any type
	T create (T ArcadeMachine);
	
	// Read All - read all objects in a list
	List<T> readAll();
	
	// Read by ID - find object by ID
	T readById(Long id);
	
	// Update - find object by Id and update its information 
	T update(Long id, T ArcadeMachine);
	
	// Delete - find object by Id and delete it
	boolean delete(Long id);
}