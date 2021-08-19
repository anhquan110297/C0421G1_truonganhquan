package models.repositories.service_repository;

import models.bean.service.Service;

import java.util.List;

public interface IServiceRepository {
    public boolean createService (Service service);
    public List<Service> displayService();
}
