package ExerciseOne;

public class Person {
    private String name;
    private String city;
    private Integer age;

    public Person(String name, String city, String age) {
        if(name == "")
                this.name="Desconocido";
        else this.name = name;
        if(city == "")
            this.name="Desconocido";
        else this.city = city;
        if(age == "")
            this.age= -1;
        else this.age = Integer.parseInt(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
