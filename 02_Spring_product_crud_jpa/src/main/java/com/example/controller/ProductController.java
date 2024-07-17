package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.exception.ResourceNotFoundException;
import com.example.service.IProductService;
//@CrossOrigin("http://localhost:4200") // Cors error
@CrossOrigin
@RestController // http://localhost:9191/api/product
@RequestMapping("/api")
public class ProductController {
     
    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> products() {
        return productService.getProductsFromDatabase();
    }

    // http://localhost:9191/api/products/101
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findByProductId(@PathVariable int id) throws ResourceNotFoundException {
        Optional<Product> product = productService.getProductById(id);
        return ResponseEntity.ok(product.orElseThrow(() -> new ResourceNotFoundException("Product not found for id " + id)));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product newProduct) {
        Product createdProduct = productService.createProduct(newProduct);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping(value = "/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(
            @PathVariable(value = "id") Integer productId, @Validated @RequestBody Product newProduct) {
        return productService.updateProduct(productId, newProduct);
    }

    // http://localhost:9191/api/products/req?id=1
    @GetMapping(path = "/products/req", produces = { MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Optional<Product>> findByProductIdUsingRequest(@RequestParam String id) {
        Optional<Product> product = productService.getProductById(Integer.parseInt(id));
        return ResponseEntity.ok(product);
    }
}
