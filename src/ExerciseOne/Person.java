package ExerciseOne;

import java.util.Optional;

public class Person {
    private String name;
    private String city;
    private String age;

    public Person(String name, String city, String age) {
        this.name = (name == "") ? null : name;
        this.city = (city == "") ? null : city;
        this.age  = (age == "") ? null : age;
    }

    public String getName() { return name; }

    public String getCity() {
        return city;
    }

    public String getAge() { return age; }

    @Override
    public String toString() {
        String response = "";
        if(name !=null)
            response += "Nombre: " + getName() + ". ";
        else response += "Nombre: Desconocido. ";
        if(city !=null)
            response += "Poblacion: " + getCity() + ". ";
        else response += "Poblacion: Desconocida. ";
        if(age !=null)
            response += "Edad: " + getAge();
        else response += "Edad: Desconocida. ";

        return response;
    }
}
