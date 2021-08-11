package models.repositories.customer_repository;

import models.bean.customer.CustomerType;


import java.util.List;

public interface ICustomerTypeRepository {
    public List<CustomerType> customerTypeList ();
}
