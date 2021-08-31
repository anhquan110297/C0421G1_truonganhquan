package com.codegym.blog.models.service;

import com.codegym.blog.models.entities.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogServiceInterface {
     public List<Blog> showList();
     public void save(Blog blog);
     public Blog findById (int id);
     public void delete(Blog blog);
}
