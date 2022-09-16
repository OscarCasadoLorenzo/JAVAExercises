package spring.springboot.WebBackend.application.Person;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.PersonInputDTO;

@FeignClient(name = "backEnterprise1", url="http://localhost:8000/")
public interface OpenFeignPersonClient {
    @GetMapping("api/backenterprise/person")
    ResponseEntity getAllPersons();

    @GetMapping("api/backenterprise/person/{id}")
    ResponseEntity getPersonByID(Integer id);

    @PostMapping("api/backenterprise/person")
    ResponseEntity postPerson(PersonInputDTO personInputDTO);

    @PutMapping("api/backenterprise/person/{id}")
    ResponseEntity updatePerson(Integer id, PersonInputDTO personaInputDTO);

    @DeleteMapping("api/backenterprise/person/{id}")
    ResponseEntity deletePerson(Integer id);
}
