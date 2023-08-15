package com.example.converter;

import com.example.entity.CategoryEntity;
import com.example.model.Category;

public class CategoryConverter {
    public static Category toModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setCateId(categoryEntity.getCateId());
        category.setCateName(categoryEntity.getCateName());
        category.setCateDesc(categoryEntity.getCateDesc());
        return category;
    }
}
