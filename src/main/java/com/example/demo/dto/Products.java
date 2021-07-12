package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
@Data
public class Products implements Serializable {
    private Paginate paging;
    private ArrayList<Product> results;
}
