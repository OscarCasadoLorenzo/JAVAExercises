package spring.springboot.JPAExercise;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String id;

    String name;
    int age;
    String city;
}
