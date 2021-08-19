package service.contract_service;

import models.bean.contract.Contract;

import java.util.List;

public interface IContractService {
    public boolean createContract (Contract contract);
    public List<Contract> showContract ();
}
