package com.codegym.models.services.employee.Interfacee;

import com.codegym.models.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    public Page<Employee> showList (Pageable pageable);
    public void save (Employee employee);
    public void delete (Employee employee);
    public Employee findById (long id);
    public Page<Employee> search (String name,Pageable pageable);
}
