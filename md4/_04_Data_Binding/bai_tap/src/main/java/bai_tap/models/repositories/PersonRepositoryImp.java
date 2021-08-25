package bai_tap.models.repositories;

import bai_tap.models.beans.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonRepositoryImp implements PersonRepositoryInterface {
    List<Person> list = new ArrayList<>();
    @Override
    public void savePerson(Person person) {
        list.add(person);
    }
}
