package com.example.demo.service;

import com.example.demo.dto.Category;
import com.example.demo.dto.ChildrenCategory;
import com.example.demo.template.MercadoLibreTemplateRest;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CategoryService {
    private MercadoLibreTemplateRest ml = new MercadoLibreTemplateRest() ;
    private ArrayList<Category> categories;

    public Category findCategoryByName(String nameCategory){
        this.setCategories(ml.getAllCategory());
        Category category = this.categories.stream().filter(e->e.isCategoryName(nameCategory)).findFirst().get();
        category.setChildren_categories((getChildrenCategory(category.getId())));
        return category;
    }

    public ArrayList<ChildrenCategory> getChildrenCategory(String id) {
        return ml.getChildenCategory(id);
    }

    public ChildrenCategory getChildrenCategoryByName(Category category, String nameCategory){
        return category.getChildren_categories().stream().filter(e->e.isCategoryName(nameCategory)).findFirst().get();
    }
}
