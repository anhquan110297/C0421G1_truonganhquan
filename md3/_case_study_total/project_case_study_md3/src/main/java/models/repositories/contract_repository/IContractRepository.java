package models.repositories.contract_repository;

import models.bean.contract.Contract;

import java.util.List;

public interface IContractRepository {
    public boolean create(Contract contract);
    public List<Contract> showContract ();
}
