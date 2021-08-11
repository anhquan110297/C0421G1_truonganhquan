package models.repositories.linked_employee;

import models.bean.employee.EducationDegree;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements ILinkedEmployeeRepository {
    BaseRepository baseRepository =new BaseRepository();
    @Override
    public List<EducationDegree> showAll() {
        List<EducationDegree> educationDegreeArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from education_degree;" );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                EducationDegree educationDegree = new EducationDegree();
                educationDegree.setEducationDegreeId(resultSet.getInt("education_degree_id"));
                educationDegree.setEducationDegreeName(resultSet.getString("education_degree_name"));
                educationDegreeArrayList.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeArrayList;
    }
}
