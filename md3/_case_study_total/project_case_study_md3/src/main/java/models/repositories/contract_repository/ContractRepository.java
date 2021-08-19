package models.repositories.contract_repository;

import models.bean.contract.Contract;
import models.bean.customer.Customer;
import models.repositories.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository{
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public boolean create(Contract contract) {
        try {
            int row = 0;
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                        "INSERT INTO contract (contract_start_date,contract_end_date,contract_deposit,\n" +
                    "contract_total_money,employee_id,customer_id,service_id)\n" +
                    "VALUES (?,?,?,?,?,?,?);");
            preparedStatement.setString(1,contract.getContractStartDate());
            preparedStatement.setString(2,contract.getContractEndDate());
            preparedStatement.setDouble(3,contract.getContractDeposit());
            preparedStatement.setDouble(4,contract.getContractTotalMoney());
            preparedStatement.setInt(5,contract.getEmployeeId());
            preparedStatement.setInt(6,contract.getCustomerId());
            preparedStatement.setInt(7,contract.getServiceId());
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
    public List<Contract> showContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement("" +
                    "select *\n" +
                    "from contract;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Contract contract = new Contract();
                contract.setContractStartDate(resultSet.getString("contract_start_date"));
                contract.setContractEndDate(resultSet.getString("contract_end_date"));
                contract.setContractDeposit(resultSet.getDouble("contract_deposit"));
                contract.setContractTotalMoney(resultSet.getDouble("contract_total_money"));
                contract.setEmployeeId(resultSet.getInt("employee_id"));
                contract.setCustomerId(resultSet.getInt("customer_id"));
                contract.setServiceId(resultSet.getInt("service_id"));
                contractList.add(contract);
            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
