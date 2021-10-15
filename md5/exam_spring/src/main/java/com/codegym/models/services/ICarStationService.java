package com.codegym.models.services;

import com.codegym.models.entity.CarStation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICarStationService {
    public Page<CarStation> findAll(Pageable pageable);
    public CarStation findById (Long id);
    public void remove (Long id);
    CarStation save(CarStation carStation);
}
