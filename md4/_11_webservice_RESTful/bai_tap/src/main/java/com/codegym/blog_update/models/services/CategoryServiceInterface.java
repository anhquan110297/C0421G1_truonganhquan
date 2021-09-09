package com.codegym.blog_update.models.services;

import com.codegym.blog_update.models.Entity.Category;

import java.util.List;

public interface CategoryServiceInterface {
    List < Category > findAll();
    void save(Category category);
    void delete(int id);
    Category findById(int id);
}
