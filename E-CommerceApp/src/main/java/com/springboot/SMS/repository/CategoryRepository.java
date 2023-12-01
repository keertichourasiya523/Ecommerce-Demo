package com.springboot.SMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SMS.model.Category;
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
