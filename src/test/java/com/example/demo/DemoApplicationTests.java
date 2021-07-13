package com.example.demo;

import com.example.demo.dto.Category;

import com.example.demo.dto.Products;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		CategoryService service = new CategoryService();
		ProductService productService = new ProductService();
		Category category = service.findCategoryByName("Motos");
		//obtener el ID
		String idCategory = service.getChildrenCategoryByName(category, "Motos").getId();
		//Productos de la categoria
		Products products = productService.getProductsByIdCategory(idCategory);
		//Productos de una marca y nuevos
		productService.getPromedioAllProductById(idCategory);
	}
}
