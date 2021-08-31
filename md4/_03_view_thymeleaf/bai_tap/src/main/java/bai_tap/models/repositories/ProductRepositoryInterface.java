package bai_tap.models.repositories;

import bai_tap.models.beans.Product;

import java.util.List;

public interface ProductRepositoryInterface {
    public List<Product> showList();
    public void save(Product product);
    public void edit (Product product);
    public Product detail (int id);
    public Product findByName (String name);
    public Product findById (int id);
    public void remove (int id);
}
