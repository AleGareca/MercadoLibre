package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
public class Products implements Serializable {
    private Paginate paging;
    private ArrayList<Product> results;


    public ArrayList<String> getAllMark() {
        ArrayList<String> rest= new ArrayList<String>();
        for(Product p: results){
            if(!rest.contains(p.getMark())){
                rest.add(p.getMark());
            }
        }
        return rest;
    }
}
