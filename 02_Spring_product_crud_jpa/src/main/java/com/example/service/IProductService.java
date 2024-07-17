package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.entity.Product;

public interface IProductService {
    ResponseEntity<List<Product>> getProductsFromDatabase();

	public Optional<Product> getProductById(int id);
	
	void deleteProductById(int id);

	Product createProduct(Product newProduct);

	ResponseEntity<Product> updateProduct(Integer productId, Product newProduct);

	

	
}
