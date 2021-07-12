package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data
public class ChildrenCategory implements Serializable {
    private String id;
    private String name;
    public boolean isCategoryName(String name){
        List<String> items = Arrays.asList(this.name.split("\\s*[,y]\\s*"));
        return items.stream().anyMatch(e -> e.equals(name));
    }
}
