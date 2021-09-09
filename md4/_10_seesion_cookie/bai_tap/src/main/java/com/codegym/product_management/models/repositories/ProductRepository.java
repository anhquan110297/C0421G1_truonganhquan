package com.codegym.product_management.models.repositories;

import com.codegym.product_management.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer > {
}
