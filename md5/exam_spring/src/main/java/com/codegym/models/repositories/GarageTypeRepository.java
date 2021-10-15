package com.codegym.models.repositories;

import com.codegym.models.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageTypeRepository extends JpaRepository<Garage,Long> {
}
