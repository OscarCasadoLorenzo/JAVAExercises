package spring.springboot.TableRelations.Persona.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;
import spring.springboot.TableRelations.Persona.domain.PersonService;
import spring.springboot.TableRelations.Persona.exception.NotFoundException;
import spring.springboot.TableRelations.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.TableRelations.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    SmartValidator validator;

    @GetMapping("/persons")
    public List<PersonaOutputDTO> getPersonsRoute(){
        List<PersonaOutputDTO> personaOutputDTOList = personService.getAllPersons();
        return personaOutputDTOList;
    }

    @GetMapping("/person/name/{name}")
    public List<PersonaOutputDTO> getPersonByNameRoute(@PathVariable String name){
         return personService.getPersonsByName(name);
    }


    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPersonByIDRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            throw new NotFoundException("Bean with id: " + id + " was not found.");
        }
        PersonaOutputDTO personaOutputDTO = personService.getPersonByID(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @PostMapping("/person")
    public PersonaOutputDTO postPersonRoute(@Valid @RequestBody PersonaInputDTO personaInputDTO){

        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<?> updatePersonRoute(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            throw new NotFoundException("Bean with id: " + id + " was not found.");
        }

        PersonaOutputDTO personaOutputDTO = personService.updatePerson(id, personaInputDTO);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);


    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePersonRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            throw new NotFoundException("Bean with id: " + id + " was not found.");
        }
        PersonaOutputDTO personaOutputDTO = personService.deletePerson(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

}
