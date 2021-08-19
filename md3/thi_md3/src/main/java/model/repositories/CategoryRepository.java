package model.repositories;

import model.bean.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ISubProductRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Category> display() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from category;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setIdCategory(resultSet.getInt("id_category"));
                category.setNameCategory(resultSet.getString("name_category"));
                categoryList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }
}
