package com.bcp.sample.user.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcp.sample.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
