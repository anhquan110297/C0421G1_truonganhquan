package models.repositories.linked_employee;

import java.util.List;

public interface ILinkedEmployeeRepository<E> {
    List<E> showAll ();
}
