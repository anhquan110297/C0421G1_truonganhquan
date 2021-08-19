package service.employee_service;

import models.bean.employee.Division;
import models.repositories.linked_employee.DivisionRepository;

import java.util.List;

public class DivisionService implements ILinkedEmployeeService {
    DivisionRepository divisionRepository = new DivisionRepository();
    @Override
    public List<Division> showAll() {
        return divisionRepository.showAll();
    }
}
