package model.repositories;

import model.bean.Product;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public Product findById(int id) {
//        Customer customer = new Customer();
//        try {
//            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
//                    "");
//            preparedStatement.setString(1,id+"");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                customer.setCustomerTypeId(resultSet.getInt("customer_id"));
//                customer.setName(resultSet.getString("customer_name"));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return null;
    }

    @Override
    public List<Product> display() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from product;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setIdProduct(resultSet.getInt("id_product"));
                product.setName(resultSet.getString("name"));
                product.setAmount(resultSet.getInt("amount"));
                product.setDescription(resultSet.getString("description"));
                product.setIdColor(resultSet.getInt("id_color"));
                product.setIdCategory(resultSet.getInt("id_category"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean create(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "INSERT INTO product (`name`, price, amount,description,\n" +
                    "                     id_color,id_category)\n" +
                    "VALUES (?,?,?,?,?,?);");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getAmount());
            preparedStatement.setString(4,product.getDescription());
            preparedStatement.setInt(5,product.getIdColor());
            preparedStatement.setInt(6,product.getIdCategory());
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                return true;
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Product product) {
//        try {
//            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
//                    "");
//            preparedStatement.setString(1,customer.getName());
//            preparedStatement.setString(2,customer.getBirthDay());
//            int row =preparedStatement.executeUpdate();
//            if (row > 0 ){
//                return true;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "DELETE FROM product\n" +
                    "WHERE id_product = ?;");
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("" +
                    "CALL search_by_name('name');\n");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setIdProduct(resultSet.getInt("id_product"));
                product.setName(resultSet.getString("name"));
                product.setAmount(resultSet.getInt("amount"));
                product.setDescription(resultSet.getString("description"));
                product.setIdColor(resultSet.getInt("id_color"));
                product.setIdCategory(resultSet.getInt("id_category"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }
}

