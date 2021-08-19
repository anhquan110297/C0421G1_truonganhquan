package service.cusomer_service;

import common.Validate;
import models.bean.customer.Customer;
import models.repositories.customer_repository.CustomerRepository;
import models.repositories.customer_repository.ICustomerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    Validate validate = new Validate();

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public List<Customer> displayCustomer() {
        return this.customerRepository.displayCustomer();
    }

    @Override
    public Map<String,String> createCustomer(Customer customer) {
        Map<String,String> message = new HashMap<>();
        if (validate.customerCode(customer.getCustomerCode()) != null ||
                validate.telephoneNumber(customer.getPhone()) != null ||
                validate.email(customer.getEmail()) != null ||
                validate.name(customer.getName()) != null) {
        message.put("customerCode",validate.customerCode(customer.getCustomerCode()));
        message.put("telephoneNumber",validate.telephoneNumber(customer.getPhone()));
        message.put("email",validate.email(customer.getEmail()));
        message.put("name",validate.name(customer.getName()));
        } else {
            this.customerRepository.createCustomer(customer);
        }
        return message;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return this.customerRepository.editCustomer(customer);
    }

    @Override
    public boolean removeCustomer(int id) {
        return this.customerRepository.removeCustomer(id);
    }
}
