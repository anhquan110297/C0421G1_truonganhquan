package com.codegym.blog_update.models.service;

import com.codegym.blog_update.models.entities.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();
    public void save (Category category);
}
