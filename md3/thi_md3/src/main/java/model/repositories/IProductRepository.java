package model.repositories;

import model.bean.Product;

import java.util.List;

public interface IProductRepository {
    public Product findById (int id);
    public List<Product> display ();
    public boolean create(Product product);
    public boolean edit(Product product);
    public boolean remove (int id);
    public List<Product> searchByName (String name);
}
