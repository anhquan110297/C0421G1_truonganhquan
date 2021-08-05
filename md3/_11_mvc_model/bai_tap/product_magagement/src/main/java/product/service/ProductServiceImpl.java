package product.service;

import product.model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductServiceInterface {
    private static Map<Integer,Product> products = new HashMap<>();
    static {
        products.put(1,new Product(1,"Shoes","The good Shoes ever",100));
        products.put(2,new Product(2,"Guitar","The good Guitar ever",50));
        products.put(3,new Product(3,"Laptop","The good Laptop ever",500));
        products.put(4,new Product(4,"Mobile","The good Mobile ever",400));
    }
    @Override
    public List<Product> display() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }


    @Override
    public void editProduct(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }

    @Override
    public Product searchProductById(String name) {
        Product temp = null;
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().equals(name)){
                temp = products.get(entry.getKey());
            }
        }
        return temp;
    }


    @Override
    public Product findById(int id) {
        return products.get(id);
    }


}
