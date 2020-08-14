package com.ssm.dao;

import com.ssm.po.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> selectCategoryList();
    public Category getCategoryById(Integer categoryId);
}
