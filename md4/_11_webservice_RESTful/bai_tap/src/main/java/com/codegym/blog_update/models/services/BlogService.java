package com.codegym.blog_update.models.services;

import com.codegym.blog_update.models.Entity.Blog;
import com.codegym.blog_update.models.repositories.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements BlogServiceInterface {
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public Page < Blog > findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public Page < Blog > findByCategory(String category, Pageable pageable) {
        return blogRepository.findAllByCategory_CategoryName(category,pageable);
    }

    @Override
    public List < Blog > showAll() {
        return blogRepository.findAll();
    }

    @Override
    public List < Blog > findBlogCategory(String category) {
        return blogRepository.findAllByCategory_CategoryName(category);
    }
}
