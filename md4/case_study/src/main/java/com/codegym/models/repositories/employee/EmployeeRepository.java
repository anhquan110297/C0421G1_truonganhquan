package com.codegym.models.repositories.employee;

import com.codegym.models.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAllByNameContaining (String name,Pageable page);
}
