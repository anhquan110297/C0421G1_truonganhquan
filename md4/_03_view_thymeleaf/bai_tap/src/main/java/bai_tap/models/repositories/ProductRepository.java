package bai_tap.models.repositories;

import bai_tap.models.beans.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional

public class ProductRepository implements ProductRepositoryInterface {
    @PersistenceContext
    private EntityManager entityManager;
    static List<Product> productList = new ArrayList<>();


    @Override
    public List<Product> showList() {
        TypedQuery<Product> query = entityManager
                .createQuery("SELECT p FROM Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(Product product) {
        for (Product n : productList) {
            if (n.getId() == product.getId()) {
                n.setName(product.getName());
                n.setPrice(product.getPrice());
                n.setDescription(product.getDescription());
                n.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public Product detail(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        for (Product n : productList) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        productList.removeIf(n -> n.getId() == id);
    }
}
