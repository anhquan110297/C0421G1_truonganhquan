package com.codegym.models.services.service.impl;

import com.codegym.models.entity.service.RentType;
import com.codegym.models.repositories.service.RentTypeRepository;
import com.codegym.models.services.service.interfacee.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceimpl implements IRentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
