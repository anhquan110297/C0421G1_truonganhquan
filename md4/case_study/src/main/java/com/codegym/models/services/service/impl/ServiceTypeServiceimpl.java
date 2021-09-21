package com.codegym.models.services.service.impl;

import com.codegym.models.entity.service.ServiceType;
import com.codegym.models.repositories.service.ServiceTypeRepository;
import com.codegym.models.services.service.interfacee.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceimpl implements IServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return this.serviceTypeRepository.findAll();
    }
}
