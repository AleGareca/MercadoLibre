package com.example.demo;

import com.example.demo.dto.Category;

import com.example.demo.dto.Products;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.template.MercadoLibreTemplateRest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {
	@Autowired
	MercadoLibreTemplateRest ml;
	@Autowired
	CategoryService service;
	@Autowired
	ProductService productService;
	@Test
	void contextLoads() {

		Category category = service.findCategoryByName("Motos");
		//obtener el ID
		String idCategory = service.getChildrenCategoryByName(category, "Motos").getId();
		//Productos de la categoria
		Products products = productService.getProductsByIdCategory(idCategory);
		//Productos de una marca y nuevos
		productService.getPromedioAllProductById(idCategory);
	}
}
