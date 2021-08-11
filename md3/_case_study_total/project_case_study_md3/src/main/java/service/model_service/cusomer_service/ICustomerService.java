package service.model_service.cusomer_service;

import models.bean.customer.Customer;

import java.util.List;

public interface ICustomerService {
    public Customer findById (int id);
    public List<Customer> displayCustomer ();
    public boolean createCustomer(int id);
    public boolean editCustomer(int id);
}
