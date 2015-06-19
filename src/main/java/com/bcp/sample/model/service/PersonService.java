package com.bcp.sample.model.service;

import java.util.Set;

import com.bcp.sample.domain.User;


public interface PersonService {

	void insertPerson(User person);
	
	User getPersonById(Long id);
	Set<User> getAllPerson();
	
	User updatePerson(User person);
	
	void deletePersonById(String id);
	
}
