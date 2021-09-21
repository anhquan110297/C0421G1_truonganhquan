package com.codegym.models.services.employee.impl;

import com.codegym.models.entity.employee.Employee;
import com.codegym.models.repositories.employee.EmployeeRepository;
import com.codegym.models.services.employee.Interfacee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> showList(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Page<Employee> search(String name,Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }
}
