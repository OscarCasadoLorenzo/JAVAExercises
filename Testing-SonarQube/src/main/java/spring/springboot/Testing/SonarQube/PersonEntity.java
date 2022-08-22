package spring.springboot.Testing.SonarQube;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue
    int id_person;

    String usuario;

    String password;

    public PersonEntity(int id, String usuario, String password) {
        this.id_person=id;
        this.usuario = usuario;
        this.password = password;
    }

    public PersonEntity(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public PersonEntity(){

    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String user) {
        this.usuario = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
