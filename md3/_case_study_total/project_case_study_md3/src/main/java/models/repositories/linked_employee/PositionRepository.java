package models.repositories.linked_employee;

import models.bean.employee.Position;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements ILinkedEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Position> showAll() {
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from `position`;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Position position = new Position();
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPositionName(resultSet.getString("position_name"));
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}
