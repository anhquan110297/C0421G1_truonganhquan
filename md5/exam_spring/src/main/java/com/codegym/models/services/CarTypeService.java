package com.codegym.models.services;

import com.codegym.models.entity.CarType;
import com.codegym.models.repositories.CarStationRepository;
import com.codegym.models.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService implements ICarTypeService {

    @Autowired
    private CarTypeRepository carTypeRepository;

    @Override
    public List<CarType> findAll() {
        return carTypeRepository.findAll();
    }
}
