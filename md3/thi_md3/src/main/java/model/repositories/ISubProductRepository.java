package model.repositories;

import model.bean.Product;

import java.util.List;

public interface ISubProductRepository<E> {
    public List<E> display ();
}
