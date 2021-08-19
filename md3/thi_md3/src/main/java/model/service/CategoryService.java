package model.service;

import model.bean.Category;
import model.repositories.CategoryRepository;
import model.repositories.ISubProductRepository;

import java.util.List;

public class CategoryService implements ISubService {
    ISubProductRepository iSubProductRepository = new CategoryRepository();
    @Override
    public List<Category> display() {
        return this.iSubProductRepository.display();
    }
}
