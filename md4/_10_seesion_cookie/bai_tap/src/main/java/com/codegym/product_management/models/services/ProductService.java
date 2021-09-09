package com.codegym.product_management.models.services;

import com.codegym.product_management.models.entity.Product;
import com.codegym.product_management.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductServices {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List < Product > findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }
}
