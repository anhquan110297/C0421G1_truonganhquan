package bai_tap.models.services;

import bai_tap.models.beans.Product;
import bai_tap.models.repositories.ProductRepository;
import bai_tap.models.repositories.ProductRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements ProductServiceInterface {
    ProductRepositoryInterface productRepository = new ProductRepository();
    @Override
    public List<Product> showList() {
        return this.productRepository.showList();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void edit(Product product) {
        this.productRepository.edit(product);
    }

    @Override
    public Product detail(int id) {
        return this.productRepository.detail(id);
    }

    @Override
    public Product findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public void remove(int id) {
        this.productRepository.remove(id);
    }
}
