package models.repositories.employee_repository;

import models.bean.employee.Employee;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    public Employee findPersonById (int id ){
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select employee_name,employee_birthday,employee_id_card,\n" +
                    "                    employee_salary,employee_phone,\n" +
                    "                    employee_email,employee_address,position_id\n" +
                    "                    ,education_degree_id,\n" +
                    "                    division_id,user_name\n" +
                    "                    from employee\n" +
                    "                    WHERE employee_id = ?;");
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setId(id);
                employee.setName(resultSet.getString("employee_name"));
                employee.setBirthDay(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getString("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setPositionID(resultSet.getInt("position_id"));
                employee.setEducationDegreeID(resultSet.getInt("education_degree_id"));
                employee.setDivisionID(resultSet.getInt("division_id"));
                employee.setUserName(resultSet.getString("user_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean CreateEmployee(Employee employee) {
        try {
            int row = 0;
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "INSERT into employee (employee_name,employee_birthday,employee_id_card\n" +
                    "\t\t\t,employee_salary,employee_phone,employee_email,employee_address\n" +
                    "            ,position_id,education_degree_id,division_id,user_name            \n" +
                    ")\n" +
                    "VALUEs (?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthDay());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setString(4,employee.getSalary()+"");
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setString(8,employee.getPositionID()+"");
            preparedStatement.setString(9,employee.getEducationDegreeID()+"");
            preparedStatement.setString(10,employee.getDivisionID()+"");
            preparedStatement.setString(11,employee.getUserName());
            row = preparedStatement.executeUpdate();
            if (row > 0 ){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> displayEmployeeList() {
        List<Employee> employeesList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select * from employee;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setBirthDay(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getString("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setPositionID(resultSet.getInt("position_id"));
                employee.setEducationDegreeID(resultSet.getInt("education_degree_id"));
                employee.setDivisionID(resultSet.getInt("division_id"));
                employee.setUserName(resultSet.getString("user_name"));
                employeesList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeesList;
    }
    @Override
    public boolean editEmployee(Employee employee) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "UPDATE employee \n" +
                    "SET employee_name = ?, employee_birthday = ?, employee_id_card = ?,employee_salary = ?,\n" +
                    "    employee_phone= ?,employee_email = ?,employee_address= ?,position_id= ?,\n" +
                    "    education_degree_id= ?,division_id= ?\n" +
                    "WHERE employee_id = ?;");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthDay());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionID());
            preparedStatement.setInt(9,employee.getEducationDegreeID());
            preparedStatement.setInt(10,employee.getDivisionID());
//            preparedStatement.setString(11,employee.getUserName());
            preparedStatement.setInt(11,employee.getId());
            row = preparedStatement.executeUpdate();
            if (row > 0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "DELETE FROM employee WHERE employee_id = ?;");
            preparedStatement.setInt(1,employee.getId());
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
