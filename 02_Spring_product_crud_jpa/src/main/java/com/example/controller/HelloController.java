package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //http://localhost:9191/api/hello
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/hello")
    String hello() {
        return "Hello World, Spring Boot.... Welcome to You!";
    }
	
	
	
}
