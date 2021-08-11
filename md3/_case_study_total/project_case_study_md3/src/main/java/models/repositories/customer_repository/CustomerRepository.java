package models.repositories.customer_repository;

import models.bean.customer.Customer;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *" +
                    "from cusomter" +
                    "where customer_id = ?");
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setCustomerTypeId(resultSet.getInt("customer_id"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthDay(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getInt("customer_gender"));
                customer.setIdCard(resultSet.getString("customer_id_card"));
                customer.setPhone(resultSet.getString("customer_phone"));
                customer.setEmail(resultSet.getString("customer_email"));
                customer.setAddress(resultSet.getString("customer_address"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerCode(resultSet.getString("customer_code"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> displayCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from customer;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setCustomerTypeId(resultSet.getInt("customer_id"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthDay(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getInt("customer_gender"));
                customer.setIdCard(resultSet.getString("customer_id_card"));
                customer.setPhone(resultSet.getString("customer_phone"));
                customer.setEmail(resultSet.getString("customer_email"));
                customer.setAddress(resultSet.getString("customer_address"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }


    @Override
    public boolean createCustomer(int id) {

        return false;
    }

    @Override
    public boolean editCustomer(int id) {
        return false;
    }
}
