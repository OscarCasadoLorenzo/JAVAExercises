package spring.springboot.CRUDExercise;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    Person getPersonById(Integer id);

    List<Person> getPersonByName(String name);

    void addPerson(Person person);
}
