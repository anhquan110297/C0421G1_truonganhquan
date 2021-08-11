package service.model_service.employee_service;

import models.bean.employee.Employee;
import models.repositories.employee_repository.EmployeeRepository;
import models.repositories.employee_repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public Employee findPersonById(int id) {
        return this.employeeRepository.findPersonById(id);
    }

    @Override
    public boolean CreateEmployee(Employee employee) {
        return this.employeeRepository.CreateEmployee(employee);
    }

    @Override
    public List<Employee> displayEmployeeList() {
        return this.employeeRepository.displayEmployeeList();
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return this.employeeRepository.editEmployee(employee);
    }

    @Override
    public boolean removeEmployee(Employee employee) {
        return this.employeeRepository.removeEmployee(employee);
    }
}
