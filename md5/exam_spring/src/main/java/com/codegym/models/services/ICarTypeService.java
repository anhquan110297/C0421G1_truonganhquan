package com.codegym.models.services;

import com.codegym.models.entity.CarType;
import com.codegym.models.entity.Garage;

import java.util.List;

public interface ICarTypeService {
    List<CarType> findAll();

}
