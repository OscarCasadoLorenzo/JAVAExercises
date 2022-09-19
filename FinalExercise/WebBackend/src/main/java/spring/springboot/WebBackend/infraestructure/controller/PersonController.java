package spring.springboot.WebBackend.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.application.Person.PersonService;
import spring.springboot.WebBackend.exceptions.UnprocesableException;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.PersonOutputDTO;

import javax.validation.Valid;
import java.util.List;

@RestController("WebBackendPersonControllerBean")
@RequestMapping("/api/backweb/person")
public class PersonController
{
    @Autowired
    PersonService personService;

    @GetMapping
    public List<PersonOutputDTO> getPersonsRoute(){
        return personService.getAllPersons();
    }


    @GetMapping("/{id}")
    public PersonOutputDTO getPersonByIDRoute(@PathVariable Integer id){
        return personService.getPersonByID(id);
    }

    @PostMapping
    public PersonOutputDTO postPersonRoute(@Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{id}")
    public PersonOutputDTO updatePersonRoute(@PathVariable Integer id, @Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personService.updatePerson(id, personaInputDTO);
    }

    @DeleteMapping("/{id}")
    public PersonOutputDTO deletePersonRoute(@PathVariable Integer id){
        return personService.deletePerson(id);
    }
}
