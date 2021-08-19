package service.service_service;

import models.bean.service.Service;

import java.util.List;

public interface IServiceService {
    public boolean createService (Service service);
    public List<Service> displayService();
}
