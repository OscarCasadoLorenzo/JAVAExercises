package spring.springboot.Testing.SonarQube;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue
    int id_person;

    @Column(nullable = false)
    String usuario;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String name;

    String surname;

    @Column(nullable = false)
    String company_email;

    @Column(nullable = false)
    String personal_email;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    boolean active;

    Date created_date;

    String image_url;

    Date termination_date;

}
