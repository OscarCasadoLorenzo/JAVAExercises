package spring.springboot.CRUDExercise;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController("/personController")
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    private AtomicInteger counter = new AtomicInteger();

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Integer id){
        return null;
    }

    @GetMapping("/person/name/{name}")
    public Person getPerson(@PathVariable String name){
        return null;
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody ObjectNode requestPerson){
        String personName = requestPerson.get("name").asText();
        String personCity = requestPerson.get("city").asText();
        String personAge = requestPerson.get("age").asText();

        Person newPerson = new Person(personName, personCity, personAge);
        personService.addPerson(newPerson);
        return newPerson;
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(){
        return null;
    }

    @DeleteMapping("/person/{id}")
    public Person deletePerson(){
        return null;
    }
}
