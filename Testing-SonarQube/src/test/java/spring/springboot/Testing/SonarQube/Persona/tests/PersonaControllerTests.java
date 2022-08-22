package spring.springboot.Testing.SonarQube.Persona.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import spring.springboot.Testing.SonarQube.PersonEntity;
import spring.springboot.Testing.SonarQube.Persona.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.Testing.SonarQube.PersonRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonaControllerTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private PersonRepository personRepository;

    private String baseURL = "http://localhost:8080/person";

    @BeforeAll
    public void setup(){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("PersonNameTest");
        personEntity.setUsuario("PersonUserTest");
        personEntity.setSurname("PersonSurnameTest");
        personEntity.setCity("PersonCityTest");
        personEntity.setPassword("PersonPasswordTest");
        personEntity.setPersonal_email("PersonNameTest");
        personEntity.setCompany_email("PersonNameTest");
        personEntity.setCreated_date(new Date(System.currentTimeMillis()));
        personEntity.setTermination_date(new Date(1999, 01, 01));


        personRepository.save(personEntity);
    }

    @Test
    public void testAddPersonSucces() throws URISyntaxException {
        URI uri = new URI(baseURL);

        RequestEntity<Void> request= RequestEntity.get(uri)
                .accept(MediaType.APPLICATION_JSON).build();

        ParameterizedTypeReference<List<PersonaOutputDTO>> myList =
                new ParameterizedTypeReference<List<PersonaOutputDTO>>() {}; // Use this so it can return a List

        ResponseEntity<List<PersonaOutputDTO>> responseEntity= testRestTemplate.exchange(request, myList);

        Assertions.assertEquals(responseEntity.getStatusCodeValue(),200);
        var respuesta=responseEntity.getBody();
        Assertions.assertEquals(respuesta.size(),1);
        Assertions.assertEquals(respuesta.get(0).getName(),"PersonNameTest");

    }
}
