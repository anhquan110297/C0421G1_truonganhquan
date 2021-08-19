package models.repositories.service_repository;

import models.bean.service.ServiceType;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements ISubServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<ServiceType> showList() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from service_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ServiceType serviceType = new ServiceType();
                serviceType.setServiceType(resultSet.getInt("service_type_id"));
                serviceType.setServiceTypeName(resultSet.getString("service_type_name"));
                serviceTypes.add(serviceType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return serviceTypes;
    }
}
