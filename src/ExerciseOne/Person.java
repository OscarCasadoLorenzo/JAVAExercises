package ExerciseOne;

import java.util.Optional;

public class Person {
    private String name;
    private String city;
    private String age;

    public Person(String name, String city, String age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
