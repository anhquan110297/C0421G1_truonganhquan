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
                    "select * \n" +
                    "from customer \n" +
                    "where customer_id = ?");
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setCustomerTypeId(resultSet.getInt("customer_id"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthDay(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getBoolean("customer_gender"));
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
                customer.setId(resultSet.getInt("customer_id"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthDay(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getBoolean("customer_gender"));
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
    public boolean createCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "INSERT INTO customer (customer_name,customer_birthday,customer_gender,customer_id_card\n" +
                    "        ,customer_phone,customer_email,customer_address,customer_type_id,customer_code)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getBirthDay());
            preparedStatement.setBoolean(3,customer.isGender());
            preparedStatement.setString(4,customer.getIdCard());
            preparedStatement.setString(5,customer.getPhone());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getAddress());
            preparedStatement.setInt(8,customer.getCustomerTypeId());
            preparedStatement.setString(9,customer.getCustomerCode());
            int row = preparedStatement.executeUpdate();
            if (row > 0 ){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean editCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "UPDATE customer\n" +
                    "SET customer_name = ?,customer_birthday = ?,customer_gender = ?,customer_id_card = ?,customer_phone = ?,\n" +
                    "customer_email = ?,customer_address = ?,customer_type_id = ?,customer_code = ?\n" +
                    "WHERE customer_id = ?;");
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getBirthDay());
            preparedStatement.setBoolean(3,customer.isGender());
            preparedStatement.setString(4,customer.getIdCard());
            preparedStatement.setString(5,customer.getPhone());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getAddress());
            preparedStatement.setInt(8,customer.getCustomerTypeId());
            preparedStatement.setString(9,customer.getCustomerCode());
            preparedStatement.setInt(10,customer.getId());
            int row =preparedStatement.executeUpdate();
            if (row > 0 ){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeCustomer(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "DELETE FROM customer WHERE customer_id = ?;");
            preparedStatement.setInt(1,id);
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
