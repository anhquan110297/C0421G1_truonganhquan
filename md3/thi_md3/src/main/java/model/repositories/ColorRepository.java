package model.repositories;

import model.bean.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorRepository implements ISubProductRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Color> display() {
        List<Color> colorList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from color;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Color color = new Color();
                color.setIdColor(resultSet.getInt("id_color"));
                color.setNameColor(resultSet.getString("name_color"));
                colorList.add(color);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return colorList;
    }
}
