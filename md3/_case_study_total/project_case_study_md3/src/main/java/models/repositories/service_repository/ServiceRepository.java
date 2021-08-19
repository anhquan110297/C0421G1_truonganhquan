package models.repositories.service_repository;

import models.bean.service.Service;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    BaseRepository baseRepository = new BaseRepository();


    @Override
    public boolean createService(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "INSERT INTO service (service_name,service_area,service_cost,service_max_people,\n" +
                    "standard_room,description_other_convenience,pool_area,number_of_floors,rent_type_id,\n" +
                    " service_type_id)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setDouble(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCost());
            preparedStatement.setInt(4, service.getServiceMaxPeople());
            preparedStatement.setString(5, service.getStandardRoom());
            preparedStatement.setString(6, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(7, service.getPoolArea());
            preparedStatement.setInt(8, service.getNumberOfFloor());
            preparedStatement.setInt(9, service.getRentTypeId());
            preparedStatement.setInt(10, service.getServiceTypeId());
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
    public List<Service> displayService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select * from service");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service();
                service = new Service();
                service.setServiceId(resultSet.getInt("service_id"));
                service.setServiceName(resultSet.getString("service_name"));
                service.setServiceArea(resultSet.getInt("service_area"));
                service.setServiceCost(resultSet.getDouble("service_cost"));
                service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                service.setRentTypeId(resultSet.getInt("rent_type_id"));
                service.setServiceTypeId(resultSet.getInt("service_type_id"));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
                service.setPoolArea(resultSet.getInt("pool_area"));
                service.setNumberOfFloor(resultSet.getInt("number_of_floors"));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

}
