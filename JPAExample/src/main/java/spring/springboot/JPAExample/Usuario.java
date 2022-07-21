package spring.springboot.JPAExample;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue
    Integer identificador;
    String city;
    Integer age;
}
