package com.example.demo.service;

import com.example.demo.dto.Product;
import com.example.demo.dto.Products;
import com.example.demo.template.MercadoLibreTemplateRest;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
public class ProductService {
    private MercadoLibreTemplateRest ml = new MercadoLibreTemplateRest();

    public static int getPromedioPrecio(Products products) {

    }

    public Products getProductsByIdCategory(String idCategory) {

        return ml.getProductsByIdCategory(idCategory);
    }

    public ArrayList<Product> getProductsByMarkAndStatus(String name, String status, Products products) {
        ArrayList<Product> product = products.getResults();
        ArrayList<Product> res = new ArrayList();
        for (Product e : product) {
            if (e.getAttributesByName(name, status)) {
                res.add(e);
            }
        }
        return res;
    }
}

