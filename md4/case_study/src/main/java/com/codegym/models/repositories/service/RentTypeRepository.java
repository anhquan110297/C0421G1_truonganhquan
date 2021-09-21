package com.codegym.models.repositories.service;

import com.codegym.models.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository <RentType,Long> {
}
