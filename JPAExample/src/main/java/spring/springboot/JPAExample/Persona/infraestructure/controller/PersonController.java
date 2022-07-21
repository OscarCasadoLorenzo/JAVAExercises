package spring.springboot.JPAExample.Persona.infraestructure.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.JPAExample.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

@Slf4j
@RestController
public class PersonController {

    @GetMapping("/persona")
    public List<PersonaOutputDTO> getPersons(){

        List<PersonaOutputDTO> personaListOutputDTO;
        return personaListOutputDTO;
    }

    @GetMapping("/person/{id}")
    public PersonaOutputDTO getPerson(@PathVariable int id){
        //If ID doesnt exists then return 404
        PersonaOutputDTO personaOutputDTO;
        return personaOutputDTO;
    }

    @PostMapping("/persona")
    public PersonaOutputDTO postPerson(@RequestBody PersonaInputDTO personaInputDTO){

        PersonaOutputDTO personaOutputDTO;
        return personaOutputDTO;

    }

    @PutMapping("/person/{id}")
    public PersonaOutputDTO updatePerson(@PathVariable int id){
        //If ID doesnt exists then return 404

        PersonaOutputDTO personaOutputDTO;
        return personaOutputDTO;
    }

    @DeleteMapping("/person/{id}")
    public PersonaOutputDTO updatePerson(@PathVariable int id){
        //If ID doesnt exists then return 404

        PersonaOutputDTO personaOutputDTO;
        return personaOutputDTO;
    }


}
