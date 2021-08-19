package model.service;

import model.bean.Product;

import java.util.List;

public interface IProductService {
    public List<Product> display ();
    public boolean create(Product product);
    public boolean remove (int id);
    public List<Product> searchByName (String name);

}
