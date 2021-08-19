package service.cusomer_service;

import models.bean.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    public Customer findById (int id);
    public List<Customer> displayCustomer ();
    public Map<String,String> createCustomer(Customer customer);
    public boolean editCustomer(Customer customer);
    public boolean removeCustomer (int id);
}
