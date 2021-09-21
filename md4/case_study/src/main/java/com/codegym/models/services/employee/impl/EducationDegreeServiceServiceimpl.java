package com.codegym.models.services.employee.impl;

import com.codegym.models.entity.employee.EducationDegree;
import com.codegym.models.repositories.employee.EducationDegreeRepository;
import com.codegym.models.services.employee.Interfacee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceServiceimpl implements IEducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
