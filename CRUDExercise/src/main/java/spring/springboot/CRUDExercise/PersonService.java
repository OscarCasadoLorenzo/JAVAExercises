package spring.springboot.CRUDExercise;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    Person getPerson(Integer id);

    Person addPerson(Person person);
}
