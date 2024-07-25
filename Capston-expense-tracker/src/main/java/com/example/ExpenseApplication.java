package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//http://localhost:8086/swagger-ui/index.html#/participant-controller/getParticipantByName

 
//@EnableSwagger2
//@EnableJpaRepositories(basePackages="com.example.dao")
//@EntityScan(basePackages="com.example.controller")
//@SpringBootApplication(scanBasePackages="com.example")
@EnableFeignClients
@SpringBootApplication
public class ExpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseApplication.class, args);
	}
}
