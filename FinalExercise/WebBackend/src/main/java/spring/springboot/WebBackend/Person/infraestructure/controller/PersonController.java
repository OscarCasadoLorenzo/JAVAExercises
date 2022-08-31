package spring.springboot.WebBackend.Person.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.WebBackend.Person.domain.PersonService;

@RestController
@RequestMapping("/api/v0")
public class PersonController
{
    @Autowired
    PersonService personService;
}
