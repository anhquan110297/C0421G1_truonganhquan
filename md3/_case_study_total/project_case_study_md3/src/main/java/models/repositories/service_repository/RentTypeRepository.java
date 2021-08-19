package models.repositories.service_repository;

import models.bean.service.RentType;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements ISubServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<RentType> showList() {
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from rent_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RentType rentType = new RentType();
                rentType.setRentTypeId(resultSet.getInt("rent_type_id"));
                rentType.setRentTypeName(resultSet.getString("rent_type_name"));
                rentTypeList.add(rentType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rentTypeList;
    }
}
