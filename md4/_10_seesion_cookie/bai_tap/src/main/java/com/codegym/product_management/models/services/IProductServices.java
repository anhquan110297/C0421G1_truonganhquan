package com.codegym.product_management.models.services;

import com.codegym.product_management.models.entity.Product;

import java.util.List;

public interface IProductServices {
    public List< Product > findAll();
    public Product findById(int id);
    public void save(Product product);

}
