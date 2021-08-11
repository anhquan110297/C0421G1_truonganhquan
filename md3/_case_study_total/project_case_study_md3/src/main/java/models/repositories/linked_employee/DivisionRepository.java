package models.repositories.linked_employee;

import models.bean.employee.Division;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements ILinkedEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Division> showAll() {
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from division;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Division division = new Division();
                division.setDivisionId(resultSet.getInt("division_id"));
                division.setDivisionName(resultSet.getString("division_name"));
                divisionList.add(division);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
}
