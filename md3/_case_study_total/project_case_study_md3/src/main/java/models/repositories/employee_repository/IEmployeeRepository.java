package models.repositories.employee_repository;

import models.bean.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public Employee findPersonById (int id );
    public boolean CreateEmployee (Employee employee);
    public List<Employee> displayEmployeeList ();
    public boolean editEmployee (Employee employee);
    public boolean removeEmployee (Employee employee);
}
