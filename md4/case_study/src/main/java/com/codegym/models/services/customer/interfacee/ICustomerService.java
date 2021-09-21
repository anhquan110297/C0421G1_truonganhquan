package com.codegym.models.services.customer.interfacee;

import com.codegym.models.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    public Page<Customer> findAll (Pageable pageable);
    public Customer findById (Long id);
    public void save (Customer customer);
    public void delete (Customer customer);
}
