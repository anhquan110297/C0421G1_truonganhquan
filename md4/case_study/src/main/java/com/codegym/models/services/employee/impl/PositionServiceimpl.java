package com.codegym.models.services.employee.impl;

import com.codegym.models.entity.employee.Position;
import com.codegym.models.repositories.employee.PositionRepository;
import com.codegym.models.services.employee.Interfacee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceimpl implements IPositionService {
    @Autowired
     PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
