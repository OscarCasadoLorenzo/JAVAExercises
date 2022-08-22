package spring.springboot.Testing.SonarQube;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePersonTest(){

        PersonEntity persona = new PersonEntity("Vicente", "PasswordVicente");
        personRepository.save(persona);
        Assertions.assertThat(persona.getId_person()).isPositive();
    }

    @Test
    @Order(2)
    public void getPersonTest(){

        PersonEntity persona = personRepository.findById(1).get();
        Assertions.assertThat(persona.getId_person()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getPersonByUser(){

        Optional<PersonEntity> optionalPersona = personRepository.findByUsuario("Vicente");
        Assertions.assertThat(optionalPersona.get().getUsuario()).isEqualTo("Vicente");
    }

    @Test
    @Order(4)
    public void getListOfPersonsTest(){

        List<PersonEntity> personas = personRepository.findAll();
        Assertions.assertThat(personas.size()).isPositive();
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void updatePersonTest(){

        PersonEntity persona = personRepository.findById(1).get();
        persona.setUsuario("NuevoUsuarioTest");
        PersonEntity personaActualizada =  personRepository.save(persona);
        Assertions.assertThat(personaActualizada.getUsuario()).isEqualTo("NuevoUsuarioTest");
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void deletePersonTest(){

        PersonEntity persona = personRepository.findById(1).get();
        personRepository.delete(persona);
        PersonEntity personaNull = null;
        Optional<PersonEntity> optionalPersona = personRepository.findByUsuario("Vicente");

        if(optionalPersona.isPresent()){
            personaNull = optionalPersona.get();
        }
        Assertions.assertThat(personaNull).isNull();
    }
}
