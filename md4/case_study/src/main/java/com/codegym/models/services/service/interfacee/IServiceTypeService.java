package com.codegym.models.services.service.interfacee;

import com.codegym.models.entity.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
