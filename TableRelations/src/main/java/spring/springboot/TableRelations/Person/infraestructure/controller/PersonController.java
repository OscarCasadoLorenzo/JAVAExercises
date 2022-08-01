package spring.springboot.TableRelations.Person.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;
import spring.springboot.TableRelations.Person.domain.PersonService;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;

import javax.validation.Valid;
import java.util.List;

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


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonByIDRoute(@PathVariable int id){
     try{
         return new ResponseEntity<>(personService.getPersonByID(id), HttpStatus.OK);
     } catch (Exception e){
         return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
     }


    }

    @PostMapping
    public PersonaOutputDTO postPersonRoute(@Valid @RequestBody PersonaInputDTO personaInputDTO){

        return personService.postPerson(personaInputDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonRoute(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        PersonaOutputDTO personaOutputDTO = personService.updatePerson(id, personaInputDTO);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonRoute(@PathVariable int id){
        //If ID doesnt exists then return 404
        if(!personService.existsPerson(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        PersonaOutputDTO personaOutputDTO = personService.deletePerson(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
    }

    @GetMapping("teacher/{id}")
    public ResponseEntity<?> getTeacherRoute(@PathVariable int id){
        return personService.getTeacher(id);
    }

}
