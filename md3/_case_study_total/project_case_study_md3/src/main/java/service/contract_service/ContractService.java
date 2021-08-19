package service.contract_service;

import models.bean.contract.Contract;
import models.repositories.contract_repository.ContractRepository;

import java.util.List;

public class ContractService implements IContractService {
    ContractRepository contractRepository = new ContractRepository();
    @Override
    public boolean createContract(Contract contract) {
        return this.contractRepository.create(contract);
    }

    @Override
    public List<Contract> showContract() {
        return this.contractRepository.showContract();
    }
}
