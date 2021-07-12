package com.example.demo.template;

import com.example.demo.dto.Category;
import com.example.demo.dto.ChildrenCategory;
import com.example.demo.dto.Product;
import com.example.demo.dto.Products;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
public class MercadoLibreTemplateRest {

    public UriComponents getQueryResponseAll(String path){
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.mercadolibre.com/")
                .path(path)
                .queryParam("fields","all")
                .build();
        return(uri);
    }
    private UriComponents getQueryResponseWithParam(String path, String category, String idCategory) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.mercadolibre.com/")
                .path(path)
                .queryParam(category,idCategory)
                .build();
        return(uri);
    }
    public ArrayList<Category> getAllCategory(){
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = getQueryResponseAll("sites/MLA/categories");
        ResponseEntity<ArrayList<Category>> res = restTemplate.exchange(
                uri.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<Category>>() {});
        return res.getBody();
    }

    public ArrayList<ChildrenCategory>  getChildenCategory(String id) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = getQueryResponseAll("categories/"+id);
        ResponseEntity<Category> res = restTemplate.exchange(
                uri.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Category>() {});
        return res.getBody().getChildren_categories();
    }

    public Products getProductsByIdCategory(String idCategory) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = getQueryResponseWithParam("sites/MLA/search","category",idCategory);
        ResponseEntity<Products> res = restTemplate.exchange(
                uri.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Products>() {});
        return res.getBody();
    }

}
