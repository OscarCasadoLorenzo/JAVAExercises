package com.rest.SpringBootExercise;

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

    public void addOneYear() {
        this.age =  String.valueOf(Integer.parseInt(getAge()) +1);
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
    public String toString() {
        String response = "Nombre: " + getName() + ". "
                        + "Poblacion: " + getCity() + ". "
                        + "Edad: " + getAge();
        return response;
    }
}
