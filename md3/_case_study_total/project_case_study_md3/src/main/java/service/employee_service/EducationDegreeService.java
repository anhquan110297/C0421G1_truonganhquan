package service.employee_service;

import models.bean.employee.EducationDegree;
import models.repositories.linked_employee.EducationDegreeRepository;

import java.util.List;

public class EducationDegreeService implements ILinkedEmployeeService {
    EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> showAll() {
        return educationDegreeRepository.showAll();
    }
}
