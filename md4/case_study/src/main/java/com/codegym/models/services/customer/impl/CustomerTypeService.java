package com.codegym.models.services.customer.impl;

import com.codegym.models.entity.customer.Customer;
import com.codegym.models.entity.customer.CustomerType;
import com.codegym.models.repositories.customer.CustomerTypeRepository;
import com.codegym.models.services.customer.interfacee.ICustomerService;
import com.codegym.models.services.customer.interfacee.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
