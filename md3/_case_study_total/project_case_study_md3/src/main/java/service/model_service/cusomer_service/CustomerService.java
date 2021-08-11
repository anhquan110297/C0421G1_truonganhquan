package service.model_service.cusomer_service;

import models.bean.customer.Customer;
import models.repositories.customer_repository.CustomerRepository;
import models.repositories.customer_repository.CustomerTypeRepository;
import models.repositories.customer_repository.ICustomerRepository;
import models.repositories.customer_repository.ICustomerTypeRepository;
import models.repositories.employee_repository.EmployeeRepository;
import models.repositories.employee_repository.IEmployeeRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public List<Customer> displayCustomer() {
        return this.customerRepository.displayCustomer();
    }

    @Override
    public boolean createCustomer(int id) {
        return this.customerRepository.createCustomer(id);
    }

    @Override
    public boolean editCustomer(int id) {
        return this.customerRepository.editCustomer(id);
    }
}
