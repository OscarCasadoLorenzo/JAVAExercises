package spring.springboot.CRUDExercise;

public interface PersonService {
    String getName();
    String getCity();
    Integer getAge();
    void setName(String name);
    void setCity(String city);
    void setAge(Integer age);
    String toString();
}
