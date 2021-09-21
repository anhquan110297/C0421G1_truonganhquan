package com.codegym.models.services.customer.impl;

import com.codegym.models.entity.customer.Customer;
import com.codegym.models.repositories.customer.CustomerRepository;
import com.codegym.models.services.customer.interfacee.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
            this.customerRepository.delete(customer);
    }
}
