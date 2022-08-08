package spring.springboot.records.Persona.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.records.Persona.domain.PersonService;
import spring.springboot.records.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.records.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping
    public List<PersonaOutputDTO> getPersonsRoute(){
        List<PersonaOutputDTO> personaOutputDTOList = personService.getAllPersons();
        return personaOutputDTOList;
    }

    @GetMapping("/name/{name}")
    public List<PersonaOutputDTO> getPersonByNameRoute(@PathVariable String name){
         return personService.getPersonsByName(name);
    }

    @GetMapping("/criteriaquery")
    public List<PersonaOutputDTO> getPersonWithCriteriaQueryRoute(
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String>  user,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> creation_date,
            @RequestParam(defaultValue = "equal") String dateCondition,
            @RequestParam(required = false) Optional<String> sorting
        ){
        return personService.getPersonsWithCriteriaQuery(name, user, creation_date, dateCondition, sorting);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonByIDRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        PersonaOutputDTO personaOutputDTO = personService.getPersonByID(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @PostMapping
    public PersonaOutputDTO postPersonRoute(@RequestBody PersonaInputDTO personaInputDTO){
        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonRoute(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return  new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        PersonaOutputDTO personaOutputDTO = personService.updatePerson(id, personaInputDTO);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return  new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        PersonaOutputDTO personaOutputDTO = personService.deletePerson(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }
}
