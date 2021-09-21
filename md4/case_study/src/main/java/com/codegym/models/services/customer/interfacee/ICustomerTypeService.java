package com.codegym.models.services.customer.interfacee;

import com.codegym.models.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    public List<CustomerType> findAll ();
}
