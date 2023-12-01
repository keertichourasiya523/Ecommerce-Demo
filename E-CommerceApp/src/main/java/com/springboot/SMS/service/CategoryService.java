package com.springboot.SMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SMS.model.Category;
import com.springboot.SMS.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public void addCategory(Category category)
	{
	categoryRepository.save(category);	
	}
	
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}


	public void removeCategoryById(int id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}


	public Optional<Category> getCategoryById(int id) {

		return categoryRepository.findById(id);
	}
	
	
}
