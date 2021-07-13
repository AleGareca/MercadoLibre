package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Product implements Serializable {
    private String id;
    private String title;
    private int price;
    private ArrayList<Attribute> attributes;

    public boolean getAttributesByName(String name, String status){
        int count= 0;
        for(Attribute a:attributes){
            if (a.getValue_name().equals(status)||a.getValue_name().equals(name) ) {
                count++;
            }
        }
    return count == 2;
    }

    public String getMark(){
        String res = "";
        for(Attribute a:attributes){
            if(a.getId().equals("BRAND")){
                res = a.getValue_name();
                break;
            }
        }
        return res;
    }
    public void printData() {
        System.out.println(price);
    }
}
