package service.service_service;

import models.repositories.service_repository.ISubServiceRepository;
import models.repositories.service_repository.RentTypeRepository;

import java.util.List;

public class RentTypeService implements ISubServiceService {
    ISubServiceRepository iSubServiceRepository = new RentTypeRepository();
    @Override
    public List<RentTypeService> showList() {
        return this.iSubServiceRepository.showList();
    }
}
