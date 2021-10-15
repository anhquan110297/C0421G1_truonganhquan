package com.codegym.models.services;

import com.codegym.models.entity.Garage;

import java.util.List;

public interface IGarageService {
    List<Garage> findAll();
}
