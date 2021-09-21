package com.codegym.models.services.employee.Interfacee;

import com.codegym.models.entity.employee.Position;

import java.util.List;

public interface IPositionService {
    public List<Position> findAll();
}
