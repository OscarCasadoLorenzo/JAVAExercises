package spring.springboot.CRUDExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/personController")
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;
    
    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Integer id){

    }

    @GetMapping("/person/name/{name}")
    public Person getPerson(@PathVariable String name){

    }

    @PostMapping("/person")
    public Person addPerson(){

    }

    @PutMapping("/person/{id}")
    public Person updatePerson(){

    }

    @DeleteMapping("/person/{id}")
    public Person deletePerson(){

    }


}
