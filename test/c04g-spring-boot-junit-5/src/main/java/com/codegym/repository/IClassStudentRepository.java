package com.codegym.repository;

import com.codegym.entity.ClassStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassStudentRepository extends JpaRepository<ClassStudent, Integer> {
}
