package com.bcp.sample.user.service;

import java.util.Collection;
import java.util.Optional;

import com.bcp.sample.domain.User;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();



}
