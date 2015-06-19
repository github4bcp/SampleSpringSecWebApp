package com.bcp.sample.model.repository;

import java.util.Set;

import com.bcp.sample.domain.User;

public interface PersonRepository {
	
	void insertPerson(User person);
	
	User getPersonById(Long id);
	Set<User> getAllPerson();
	
	User updatePerson(User person);
	
	void deletePersonById(String id);
	
}
