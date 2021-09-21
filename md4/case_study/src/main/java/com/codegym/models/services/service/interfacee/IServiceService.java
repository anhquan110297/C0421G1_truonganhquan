package com.codegym.models.services.service.interfacee;

import com.codegym.models.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    Page<Service> findAll(Pageable pageable);
    void save(Service service);
}
