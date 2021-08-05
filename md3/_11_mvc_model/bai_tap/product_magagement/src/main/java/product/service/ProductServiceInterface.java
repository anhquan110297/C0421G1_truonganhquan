package product.service;

import product.model.Product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> display ();
    void addProduct(Product product);
    void editProduct(int id,Product product);
    void deleteProduct(int id);
    Product searchProductById( String name);
    Product findById(int id);
}
