package com.codegym.blog_update.models.repositories;

import com.codegym.blog_update.models.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository < Category, Integer > {

}
