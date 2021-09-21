package com.codegym.blog_update.models.service.impl;

import com.codegym.blog_update.models.entities.Category;
import com.codegym.blog_update.models.repositories.CategoryRepository;
import com.codegym.blog_update.models.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
// de truy cap quyery chinh sua duoi database de khong bi loi
@Transactional
public class CategoryServiceimpl implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List < Category > findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }
}
