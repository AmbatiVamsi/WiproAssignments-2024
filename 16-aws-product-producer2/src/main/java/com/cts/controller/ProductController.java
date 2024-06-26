package com.cts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cts.model.Product;

@RestController
//@RequestMapping("/api/prd")
public class ProductController {

	@RequestMapping("/Products")
	 public List<Product> getProducts() {
		 List<Product> prdList= new ArrayList<Product>();
		 prdList.add(new Product(10, 100,"pen"));
		 prdList.add(new Product(10,200,"book"));
		 prdList.add(new Product(20,300,"notes"));
		 return prdList; 
}
}
	