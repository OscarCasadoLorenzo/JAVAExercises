package spring.springboot.JPAExercise;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    String id;

    String name;
    int age;
    String city;
}
