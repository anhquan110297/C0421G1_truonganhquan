package com.codegym.models.services;

import com.codegym.models.entity.CarStation;
import com.codegym.models.repositories.CarStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStationService implements ICarStationService {

    @Autowired
    private CarStationRepository carStationRepository;

    @Override
    public Page<CarStation> findAll(Pageable pageable) {

        return carStationRepository.findAll(pageable);
    }

    @Override
    public CarStation findById(Long id) {
        return this.carStationRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        this.carStationRepository.deleteById(id);
    }

    @Override
    public CarStation save(CarStation carStation) {
        return this.carStationRepository.save(carStation);
    }


}
