package service.service_service;

import models.repositories.service_repository.ISubServiceRepository;
import models.repositories.service_repository.ServiceTypeRepository;

import java.util.List;

public class ServiceTypeService implements ISubServiceService {
    ISubServiceRepository iSubServiceRepository = new ServiceTypeRepository();
    @Override
    public List<ServiceTypeService> showList() {
        return this.iSubServiceRepository.showList();
    }
}
