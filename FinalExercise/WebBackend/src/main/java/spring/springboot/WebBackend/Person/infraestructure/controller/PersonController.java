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
import java.util.UUID;

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
    public PersonOutputDTO getPersonByIDRoute(@PathVariable UUID id){
        return personService.getPersonByID(id);
    }

    @PostMapping
    public PersonOutputDTO postPersonRoute(@Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{id}")
    public PersonOutputDTO updatePersonRoute(@PathVariable UUID id, @Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personService.updatePerson(id, personaInputDTO);
    }

    @DeleteMapping("/{id}")
    public PersonOutputDTO deletePersonRoute(@PathVariable UUID id){
        return personService.deletePerson(id);
    }
}
