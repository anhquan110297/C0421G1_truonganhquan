package service.service_service;

import models.bean.service.Service;
import models.repositories.service_repository.ServiceRepository;

import java.util.List;

public class ServiceService implements IServiceService {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public boolean createService(Service service) {
        return this.serviceRepository.createService(service);
    }

    @Override
    public List<Service> displayService() {
        return serviceRepository.displayService();
    }
}
