package spring.springboot.JPAExample.Persona.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.JPAExample.Persona.domain.PersonService;
import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<?> getPersonsRoute(){
        List<PersonaOutputDTO> personaOutputDTOList = personService.getAllPersons();
        return new ResponseEntity<>(personaOutputDTOList, HttpStatus.OK);
    }

    @GetMapping("/person/name/{name}")
    public List<PersonaOutputDTO> getPersonByNameRoute(@PathVariable String name){
         return personService.getPersonsByName(name);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPersonByIDRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        PersonaOutputDTO personaOutputDTO = personService.getPersonByID(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @PostMapping("/person")
    public PersonaOutputDTO postPersonRoute(@RequestBody PersonaInputDTO personaInputDTO){
        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/person/{id}")
    public PersonaOutputDTO updatePersonRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        return null;
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePersonRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        PersonaOutputDTO personaOutputDTO = personService.deletePerson(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

}
