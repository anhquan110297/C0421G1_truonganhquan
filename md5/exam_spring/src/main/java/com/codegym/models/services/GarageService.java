package com.codegym.models.services;

import com.codegym.models.entity.Garage;
import com.codegym.models.repositories.CarStationRepository;
import com.codegym.models.repositories.GarageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService implements  IGarageService{

    @Autowired
    private GarageTypeRepository garageTypeRepository;

    @Override
    public List<Garage> findAll() {
        return garageTypeRepository.findAll();
    }
}
