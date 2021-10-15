package com.codegym.models.repositories;

import com.codegym.models.entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType,Long> {
}
