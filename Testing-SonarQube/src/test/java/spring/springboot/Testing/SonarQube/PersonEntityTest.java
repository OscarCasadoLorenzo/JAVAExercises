package spring.springboot.Testing.SonarQube;

import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonEntityTest {

    @Test
    public void crearPersona() {
        PersonEntity persona = new PersonEntity(1,"Vicente", "PasswordVicente");
        Assertions.assertThat(persona.getId_person()).isEqualTo(1);
        Assertions.assertThat(persona.getUsuario()).isEqualTo("Vicente");
        Assertions.assertThat(persona.getPassword()).isEqualTo("PasswordVicente");
    }
}
