package spring.springboot.TableRelations.Person.infraestructure.controller;

import com.sun.source.tree.TryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.TableRelations.Person.domain.PersonService;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.input.PersonaInputDTO;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.TableRelations.Person.proxy.TeacherServiceProxy;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    TeacherServiceProxy teacherServiceProxy;

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

    @GetMapping("/criteriaquery")
    public List<PersonaOutputDTO> getPersonWithCriteriaQueryRoute(
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String>  surname,
            @RequestParam(required = false) Optional<String>  company,
            @RequestParam(required = false) Optional<String>  teacherName
    ){
        return personService.getPersonWithCriteriaQuery(name, surname, company, teacherName);
    }

    @PostMapping
    public ResponseEntity<?> postPersonRoute(@Valid @RequestBody PersonaInputDTO personaInputDTO){
        try {
            return new ResponseEntity<>(personService.postPerson(personaInputDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

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

    @GetMapping("RESTemplate/teacher/{id}")
    public ResponseEntity<?> getTeacherWithTemplateRoute(@PathVariable int id){
        try {
            return personService.getTeacherWithTemplate(id);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("Feign/teacher/{id}")
    public ResponseEntity<?> getTeacherWithFeignRoute(@PathVariable int id){
        try {
            return teacherServiceProxy.getTeacher(id);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
