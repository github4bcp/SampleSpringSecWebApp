package com.bcp.sample.model.repository.jdbc;

import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bcp.sample.domain.User;
import com.bcp.sample.model.repository.PersonRepository;
import com.bcp.sample.model.repository.jdbc.support.PersonRowMapper;

@Transactional
@Repository("personRepository")
public class PersonJdbcRepository implements PersonRepository {

	private static final Logger logger = LoggerFactory.getLogger(PersonJdbcRepository.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PersonJdbcRepository(JdbcTemplate jdbcTemplate){
		logger.info("PersonJdbcRepository arg constructor");
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertPerson(User person) {
		String sql = "INSERT INTO person(id, email, password_hash,role) VALUES(?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, person.getId(), person.getEmail(), person.getPasswordHash(),person.getRole().toString());	
	}

	@Override
	public User getPersonById(Long id) {
		String sql = "SELECT p.* FROM person p WHERE p.id=?";
		return this.jdbcTemplate.queryForObject(sql, new PersonRowMapper(), id); 
	}

	@Override
	public Set<User> getAllPerson() {
		String sql = "SELECT p.* FROM person p";		
		return new LinkedHashSet<User>(this.jdbcTemplate.query(sql, new PersonRowMapper()));
	}

	@Override
	public User updatePerson(User person) {
		String sql = "UPDATE person p SET p.email=?, p.password_hash=? WHERE p.id=?";
		this.jdbcTemplate.update(sql, person.getEmail(), person.getPasswordHash(), person.getId());
		return person;
	}

	@Override
	public void deletePersonById(String id) {
		String sql = "DELETE FROM person WHERE id=?";
		jdbcTemplate.update(sql, id);
	}
	
}
