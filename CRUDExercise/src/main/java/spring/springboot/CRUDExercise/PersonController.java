package spring.springboot.CRUDExercise;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController("/personController")
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Integer id){
        return personService.getPersonById(id);
    }

    @GetMapping("/person/name/{name}")
    public List<Person> getPersonByName(@PathVariable String name){
        return personService.getPersonByName(name);
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
    public Person updatePerson(@RequestBody ObjectNode requestPerson, @PathVariable Integer id){
        String personName;
        String personCity;
        String personAge;

//        personName = Optional.ofNullable(requestPerson.get("name")).ifPresent(n -> n.asText()).orElse("");
//        personCity = Optional.ofNullable(requestPerson.get("city").asText()).orElse("");
//        personAge = Optional.ofNullable(requestPerson.get("age").asText()).orElse("");

        if(requestPerson.has("name"))
            personName = requestPerson.get("name").asText();
        else personName = "";

        if(requestPerson.has("city"))
            personCity = requestPerson.get("city").asText();
        else personCity = "";

        if(requestPerson.has("age"))
            personAge = requestPerson.get("age").asText();
        else personAge = "";


        Person updatePerson = new Person(personName, personCity, personAge);
        return personService.updatePerson(id, updatePerson);
    }

    @DeleteMapping("/person/{id}")
    public Person deletePerson(@PathVariable Integer id){
        return personService.deletePerson(id);
    }
}
