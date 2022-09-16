package spring.springboot.WebBackend.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.application.Person.OpenFeignPersonClient;
import spring.springboot.WebBackend.exceptions.UnprocesableException;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.PersonInputDTO;

import javax.validation.Valid;
import java.util.List;

@RestController("WebBackendPersonControllerBean")
@RequestMapping("/api/backweb/person")
public class PersonController
{
    @Autowired
    OpenFeignPersonClient personClient;

    @GetMapping
    public ResponseEntity getPersonsRoute(){
        return personClient.getAllPersons();
    }


    @GetMapping("/{id}")
    public ResponseEntity getPersonByIDRoute(@PathVariable Integer id){
        return personClient.getPersonByID(id);
    }

    @PostMapping
    public ResponseEntity postPersonRoute(@Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personClient.postPerson(personaInputDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePersonRoute(@PathVariable Integer id, @Valid @RequestBody PersonInputDTO personaInputDTO, BindingResult errors){
        if(errors.hasErrors())
            throw new UnprocesableException(errors);
        return personClient.updatePerson(id, personaInputDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePersonRoute(@PathVariable Integer id){
        return personClient.deletePerson(id);
    }
}
