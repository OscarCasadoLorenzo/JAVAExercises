package spring.springboot.CRUDExercise;

public class Person{

    private String name;
    private String city;
    private Integer age;

    public Person(String name, String city, String age) {
        this.name = (name.equals("")) ? null : name;
        this.city = (city.equals("")) ? null : city;
        this.age  = (age.equals(""))  ? null : Integer.parseInt(age);
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "Nombre: " + getName() + ". "
                    + "Poblacion: " + getCity() + ". "
                    + "Edad: " + getAge();
    }
}
