package com.springboot.SMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SMS.model.Product;
import com.springboot.SMS.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	
	public void addProduct(Product product)
	{
		productRepository.save(product);
	}
	
	public void removeProductById(long id)
	{
		productRepository.deleteById(id);
	}
	
	public Optional<Product> getProductById(long id)
	{
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProductByCategoryId(int id)
	{
		return productRepository.findAllByCategory_Id(id);
	}

	
	
	
	
	
}
