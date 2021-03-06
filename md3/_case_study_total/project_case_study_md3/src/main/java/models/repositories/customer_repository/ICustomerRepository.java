package models.repositories.customer_repository;

import models.bean.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    public Customer findById (int id);
    public List<Customer> displayCustomer ();
    public boolean createCustomer(Customer customer);
    public boolean editCustomer(Customer customer);
    public boolean removeCustomer (int id);
}
