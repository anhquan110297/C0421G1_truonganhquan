package service.model_service.employee_service;

import models.bean.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee findPersonById (int id );
    public boolean CreateEmployee (Employee employee);
    public List<Employee> displayEmployeeList ();
    public boolean editEmployee (Employee employee);
    public boolean removeEmployee (Employee employee);
}
