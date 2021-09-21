package com.codegym.models.services.service.impl;

import com.codegym.models.entity.service.Service;
import com.codegym.models.repositories.service.ServiceRepository;
import com.codegym.models.services.service.interfacee.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@org.springframework.stereotype.Service
public class ServiceServiceimpl implements IServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void save(Service service) {
        this.serviceRepository.save(service);
    }
}
