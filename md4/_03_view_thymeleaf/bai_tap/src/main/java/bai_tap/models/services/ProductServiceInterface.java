package bai_tap.models.services;

import bai_tap.models.beans.Product;

import java.util.List;

public interface ProductServiceInterface {
    public List<Product> showList();
    public void save(Product product);
    public void edit (Product product);
    public Product detail (int id);
    public Product findByName (String name);
    public void remove (int id);
}
