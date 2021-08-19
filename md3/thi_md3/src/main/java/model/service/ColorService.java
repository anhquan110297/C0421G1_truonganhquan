package model.service;

import model.bean.Color;
import model.repositories.ColorRepository;
import model.repositories.ISubProductRepository;

import java.util.List;

public class ColorService implements ISubService {
    ISubProductRepository iSubProductRepository = new ColorRepository();
    @Override
    public List<Color> display() {
        return this.iSubProductRepository.display();
    }
}
