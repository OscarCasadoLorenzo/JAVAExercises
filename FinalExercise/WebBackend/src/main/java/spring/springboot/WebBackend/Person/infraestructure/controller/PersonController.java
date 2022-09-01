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

@RestController("WebBackendPersonControllerBean")
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


    @GetMapping("/{dni}")
    public PersonOutputDTO getPersonByIDRoute(@PathVariable String dni){
        PersonOutputDTO personaOutputDTO = personService.getPersonByID(dni);
        return personaOutputDTO;
    }

    @PostMapping
    public PersonOutputDTO postPersonRoute(@Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<?> updatePersonRoute(@PathVariable String dni, @Valid @RequestBody PersonInputDTO personaInputDTO){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(dni)){
            throw new NotFoundException("Bean with id: " + dni + " was not found.");
        }

        PersonOutputDTO personaOutputDTO = personService.updatePerson(dni, personaInputDTO);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);


    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> deletePersonRoute(@PathVariable String dni){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(dni)){
            throw new NotFoundException("Bean with id: " + dni + " was not found.");
        }
        PersonOutputDTO personaOutputDTO = personService.deletePerson(dni);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }
}
