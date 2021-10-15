package com.codegym.models.repositories;

import com.codegym.models.entity.CarStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarStationRepository extends JpaRepository< CarStation, Long> {
}
