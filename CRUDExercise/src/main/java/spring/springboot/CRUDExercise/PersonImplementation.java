package spring.springboot.CRUDExercise;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonImplementation implements PersonService {

    List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getPersons() {
        return personList;
    }

    @Override
    public Person getPerson(Integer id) {
        Person maybePerson = personList.stream().filter(person -> person.getId()==id).findFirst().orElse(null) ;
        return maybePerson;
    }

    @Override
    public void addPerson(Person person) {
        personList.add(person);
    }
}
