package service.model_service.cusomer_service;

import models.bean.customer.CustomerType;
import models.repositories.customer_repository.CustomerTypeRepository;
import models.repositories.customer_repository.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeService implements ICustomerType {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> customerTypeList() {
        return this.customerTypeRepository.customerTypeList();
    }
}
