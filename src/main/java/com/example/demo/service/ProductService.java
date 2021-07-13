package com.example.demo.service;

import com.example.demo.dto.Product;
import com.example.demo.dto.Products;
import com.example.demo.template.MercadoLibreTemplateRest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Slf4j
public class ProductService {
    private MercadoLibreTemplateRest ml = new MercadoLibreTemplateRest();

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

    public int getPromedioAllProductByMarkAndStatus(String marca, String status,String idCategory) {
        int res = 0;
        int cant = 0;
        for(int i = 0 ; i <= 1000; i++) {
            Products products = getProductsByIdAndOffset(idCategory, i);
            int total =+ products.getResults().size();
            ArrayList<Product> productsMS = getProductsByMarkAndStatus(marca,status,products);
            cant =+ productsMS.size();
            res =+ productsMS.stream().mapToInt(value -> value.getPrice()).sum();
            if(total <= 900){
            break;
            }
        }
        return cant > 0||res > 0 ? res/cant:0;
    }


    public Products getProductsByIdAndOffset(String idCategory, int num) {
        return ml.getProductsByIdAndOffset(idCategory,num);
    }

    public ArrayList<String> getAllMark(String idCategory){

        ArrayList<String> rest= new ArrayList<>();
        for(int i = 0 ; i <= 1000; i++) {
            Products products = getProductsByIdAndOffset(idCategory, i);
            int total =+ products.getResults().size();
            rest= products.getAllMark();
            if(total <= 100){
                break;
            }
        }
        return rest;
    }

    public void getPromedioAllProductById(String idCategory) {
        ArrayList<String> marcas = getAllMark(idCategory);
        for (String m:marcas){
            System.out.println("Marca ::"+m+ " |Promedio total:: $"+getPromedioAllProductByMarkAndStatus(m,"Nuevo",idCategory));
        }
    }

}

