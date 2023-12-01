package com.springboot.SMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SMS.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{

}