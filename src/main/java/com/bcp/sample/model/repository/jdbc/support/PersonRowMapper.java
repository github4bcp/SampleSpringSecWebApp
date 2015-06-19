package com.bcp.sample.model.repository.jdbc.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bcp.sample.domain.Role;
import com.bcp.sample.domain.User;


public class PersonRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User person = new User();
		
		person.setId(rs.getLong("id"));
		person.setEmail(rs.getString("email"));
		person.setPasswordHash(rs.getString("password_hash"));
		person.setRole(Role.ADMIN);
		
		return person;
		
	}

}
