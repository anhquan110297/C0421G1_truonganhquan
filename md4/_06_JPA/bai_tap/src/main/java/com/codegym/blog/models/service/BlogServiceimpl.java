package com.codegym.blog.models.service;

import com.codegym.blog.models.entities.Blog;
import com.codegym.blog.models.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceimpl implements BlogServiceInterface {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> showList() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.blogRepository.findById(id).orElse(new Blog());
    }

    @Override
    public void delete(Blog blog) {
        this.blogRepository.delete(blog);
    }
}
