package spring.springboot.DependencyInjection;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Person implements PersonI{
    private String name;
    private String city;
    private String age;

    public Person(String name, String city, String age) {
        this.name = (name.equals("")) ? null : name;
        this.city = (city.equals("")) ? null : city;
        this.age  = (age.equals(""))  ? null : age;
    }

    public String getName() {
        Optional<String> maybeName = Optional.ofNullable(this.name);
        return maybeName.orElse("Desconocido");
    }

    public String getCity() {
        Optional<String> maybeCity = Optional.ofNullable(this.city);
        return maybeCity.orElse("Desconocido");
    }

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
