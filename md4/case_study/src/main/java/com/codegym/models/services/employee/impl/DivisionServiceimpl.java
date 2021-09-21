package com.codegym.models.services.employee.impl;

import com.codegym.models.entity.employee.Division;
import com.codegym.models.repositories.employee.DivisionRepository;
import com.codegym.models.services.employee.Interfacee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceimpl implements IDivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
