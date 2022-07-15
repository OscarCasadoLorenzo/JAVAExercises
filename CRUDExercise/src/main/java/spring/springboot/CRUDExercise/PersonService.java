package spring.springboot.CRUDExercise;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    Person getPersonById(Integer id);

    List<Person> getPersonByName(String name);

    Person updatePerson (Integer id, Person uploadPerson);

    Person deletePerson (Integer id);

    void addPerson(Person person);
}
