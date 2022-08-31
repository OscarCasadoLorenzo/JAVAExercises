package spring.springboot.WebBackend.Person.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.Person.domain.PersonService;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;
import spring.springboot.WebBackend.exceptions.NotFoundException;
import spring.springboot.WebBackend.exceptions.UnprocesableException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v0/person")
public class PersonController
{
    @Autowired
    PersonService personService;

    @GetMapping
    public List<PersonOutputDTO> getPersonsRoute(){
        List<PersonOutputDTO> personaOutputDTOList = personService.getAllPersons();
        return personaOutputDTOList;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonByIDRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            throw new NotFoundException("Bean with id: " + id + " was not found.");
        }
        PersonOutputDTO personaOutputDTO = personService.getPersonByID(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @PostMapping
    public PersonOutputDTO postPersonRoute(@Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors.toString());
        else return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonRoute(@PathVariable int id, @RequestBody PersonInputDTO personaInputDTO){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            throw new NotFoundException("Bean with id: " + id + " was not found.");
        }

        PersonOutputDTO personaOutputDTO = personService.updatePerson(id, personaInputDTO);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            throw new NotFoundException("Bean with id: " + id + " was not found.");
        }
        PersonOutputDTO personaOutputDTO = personService.deletePerson(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }
}
