package model.service;

import model.bean.Product;
import model.repositories.IProductRepository;
import model.repositories.ProductRepository;
import model.service.common.Validate;

import java.util.List;
public class ProductService implements IProductService {
    Validate validate = new Validate();
    IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> display() {
        return this.productRepository.display();
    }

    @Override
    public boolean create(Product product) {
        return this.productRepository.create(product);
    }

    @Override
    public boolean remove(int id) {
        return this.productRepository.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return this.productRepository.searchByName(name);
    }
}
