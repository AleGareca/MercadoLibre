package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Paginate implements Serializable {
    private int total;
    private int primary_results;
    private int offset;
    private int limit;
}
