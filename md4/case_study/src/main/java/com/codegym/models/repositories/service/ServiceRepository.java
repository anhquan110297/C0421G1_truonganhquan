package com.codegym.models.repositories.service;

import com.codegym.models.entity.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
