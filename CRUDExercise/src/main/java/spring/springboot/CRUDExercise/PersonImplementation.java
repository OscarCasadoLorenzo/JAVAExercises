package spring.springboot.CRUDExercise;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonImplementation implements PersonService {

    List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getPersons() {
        return personList;
    }

    @Override
    public Person getPersonById(Integer id) {
        return personList.stream().filter(person -> person.getId()==id).findFirst().orElse(null) ;

    }

    @Override
    public List<Person> getPersonByName(String name) {
        return personList.stream().filter(person -> person.getName().equals("Estela")).collect(Collectors.toList());

    }

    @Override
    public void addPerson(Person person) {
        personList.add(person);
    }
}
