package com.example.demo;

import com.example.demo.dto.Category;
import com.example.demo.dto.Products;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
