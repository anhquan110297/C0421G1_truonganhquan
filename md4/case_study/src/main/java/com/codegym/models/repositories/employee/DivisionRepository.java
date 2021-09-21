package com.codegym.models.repositories.employee;

import com.codegym.models.entity.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Long> {
}
