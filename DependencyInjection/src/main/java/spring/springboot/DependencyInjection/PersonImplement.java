package spring.springboot.DependencyInjection;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonImplement implements PersonI{

    Person person = new Person();

    public PersonImplement(String name, String city, String age) {
        this.name = (name.equals("")) ? null : name;
        this.city = (city.equals("")) ? null : city;
        this.age  = (age.equals(""))  ? null : age;
    }

    @Override
    public String getName() {
        Optional<String> maybeName = Optional.ofNullable(this.name);
        return maybeName.orElse("Desconocido");
    }
    @Override
    public String getCity() {
        Optional<String> maybeCity = Optional.ofNullable(this.city);
        return maybeCity.orElse("Desconocido");
    }
    @Override
    public String getAge() {
        Optional<String> maybeAge = Optional.ofNullable(this.age);
        return maybeAge.orElse("Desconocido");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "Nombre: " + getName() + ". "
                    + "Poblacion: " + getCity() + ". "
                    + "Edad: " + getAge();
    }
}
