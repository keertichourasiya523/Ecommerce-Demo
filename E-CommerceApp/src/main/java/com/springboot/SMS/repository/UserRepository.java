package com.springboot.SMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SMS.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<User> findUserByEmail(String email);
}