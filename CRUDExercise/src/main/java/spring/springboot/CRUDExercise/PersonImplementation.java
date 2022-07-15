package spring.springboot.CRUDExercise;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonImplementation implements PersonService {

    Map<Integer, Person> personMap = new HashMap<>();

    @Override
    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>(personMap.values());
        return personList;
    }

    @Override
    public Person getPersonById(Integer id) {
        return personMap.get(id);

    }

    @Override
    public List<Person> getPersonByName(String name) {
        return getPersons().stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Person updatePerson(Integer id, Person uploadPerson) {
        Person updatedPerson = getPersonById(id);

        if(updatedPerson !=null){
            if(uploadPerson.getName() != null)
                updatedPerson.setName(uploadPerson.getName());
            if(uploadPerson.getCity() != null)
                updatedPerson.setCity(uploadPerson.getCity());
            if(uploadPerson.getAge() != null)
                updatedPerson.setAge(uploadPerson.getAge());
        }

        personMap.replace(id, updatedPerson);
        return updatedPerson;
    }

    @Override
    public Person deletePerson(Integer id) {
        Person deletedPerson = getPersonById(id);
        personMap.remove(id);
        return deletedPerson;
    }

    @Override
    public void addPerson(Person person) {
        personMap.put(person.getId(), person);
    }
}
