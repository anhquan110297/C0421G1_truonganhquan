package service.model_service.employee_service;


import models.bean.employee.Position;
import models.repositories.linked_employee.PositionRepository;

import java.util.List;

public class PositionService implements ILinkedEmployeeService {
    PositionRepository repository = new PositionRepository();
    @Override
    public List<Position> showAll() {
        return this.repository.showAll();
    }
}
