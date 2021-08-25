package bai_tap.models.service;

import bai_tap.models.beans.Person;
import bai_tap.models.repositories.PersonRepositoryImp;
import bai_tap.models.repositories.PersonRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonServiceInterface {
    PersonRepositoryInterface repositoryInterface = new PersonRepositoryImp();
    @Override
    public void savePerson(Person person) {
        repositoryInterface.savePerson(person);
    }
}
