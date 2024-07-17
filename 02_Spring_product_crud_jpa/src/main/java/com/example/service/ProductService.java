package com.example.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;


@Service
public class ProductService implements IProductService {
	private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepo;

    @Override
    public ResponseEntity<List<Product>> getProductsFromDatabase() {
    	
    	List<Product> products = productRepo.findAll();
    	//logger.info("Fetching all records...");
        return ResponseEntity.ok(products);
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    public Product createProduct(Product newProduct) {
        return productRepo.save(newProduct);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Integer productId, Product newProduct) {
        Optional<Product> existingProduct = productRepo.findById(productId);
        existingProduct.get().setPname(newProduct.getPname());
        existingProduct.get().setPrice(newProduct.getPrice());
        
        productRepo.save(existingProduct.get());
        return ResponseEntity.ok(existingProduct.get());
    }

	
}
