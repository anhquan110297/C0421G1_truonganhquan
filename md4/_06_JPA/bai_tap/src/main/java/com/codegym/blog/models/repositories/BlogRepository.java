package com.codegym.blog.models.repositories;

import com.codegym.blog.models.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
