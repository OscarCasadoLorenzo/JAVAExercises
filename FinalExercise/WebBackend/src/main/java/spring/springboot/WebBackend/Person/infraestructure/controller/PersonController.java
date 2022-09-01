package spring.springboot.WebBackend.Person.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.Person.domain.PersonService;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.input.PersonInputDTO;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;
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
        return personService.getAllPersons();
    }


    @GetMapping("/{dni}")
    public PersonOutputDTO getPersonByIDRoute(@PathVariable String dni){
        return personService.getPersonByID(dni);
    }

    @PostMapping
    public PersonOutputDTO postPersonRoute(@Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{dni}")
    public PersonOutputDTO updatePersonRoute(@PathVariable String dni, @Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personService.updatePerson(dni, personaInputDTO);
    }

    @DeleteMapping("/{dni}")
    public PersonOutputDTO deletePersonRoute(@PathVariable String dni){
        return personService.deletePerson(dni);
    }
}
