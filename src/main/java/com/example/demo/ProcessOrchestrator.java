package com.example.demo;

import com.example.demo.dto.Category;
import com.example.demo.dto.Products;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProcessOrchestrator {


    @Autowired
    CategoryService service;
    @Autowired
    ProductService productService;

    public void calculateMean() {
        Category category = service.findCategoryByName("Motos");
        //obtener el ID
        String idCategory = service.getChildrenCategoryByName(category, "Motos").getId();
        //Productos de la categoria
        Products products = productService.getProductsByIdCategory(idCategory);
        //Productos de una marca y nuevos
        productService.getPromedioAllProductById(idCategory);
    }
}
