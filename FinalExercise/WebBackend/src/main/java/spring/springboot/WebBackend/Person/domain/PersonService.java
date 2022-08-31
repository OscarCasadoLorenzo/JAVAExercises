package spring.springboot.WebBackend.Person.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import spring.springboot.WebBackend.Person.infraestructure.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

}
