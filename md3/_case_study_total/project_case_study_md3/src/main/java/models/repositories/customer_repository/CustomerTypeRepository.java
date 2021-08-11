package models.repositories.customer_repository;

import models.bean.customer.CustomerType;
import models.repositories.BaseRepository;
import service.model_service.cusomer_service.CustomerTypeService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<CustomerType> customerTypeList() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from customer_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CustomerType customerType = new CustomerType();
                customerType.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customerType.setCustomerName(resultSet.getString("customer_type_name"));
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
