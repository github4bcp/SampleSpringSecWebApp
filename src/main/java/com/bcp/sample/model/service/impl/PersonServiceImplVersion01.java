package com.bcp.sample.model.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcp.sample.domain.User;
import com.bcp.sample.model.repository.PersonRepository;
import com.bcp.sample.model.service.PersonService;


@Transactional
@Service("personService01")
public class PersonServiceImplVersion01 implements PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImplVersion01.class);
	
	private PersonRepository personRepository;
	
	public PersonServiceImplVersion01(){
		logger.info("PersonServiceImplVersion01 no-arg constructor");
	}
	
	@Autowired
	public PersonServiceImplVersion01(PersonRepository personRepository){
		logger.info("PersonServiceImplVersion01 arg constructor");
		this.personRepository = personRepository;
	}
	
	@Override
	public void insertPerson(User person) {
		this.personRepository.insertPerson(person);
	}

	@Override
	public User getPersonById(Long id) {
		return this.personRepository.getPersonById(id);
	}

	@Override
	public Set<User> getAllPerson() {
		return this.personRepository.getAllPerson();
	}

	@Override
	public User updatePerson(User person) {
		return this.personRepository.updatePerson(person);
	}

	@Override
	public void deletePersonById(String id) {
		this.personRepository.deletePersonById(id);
	}

}
