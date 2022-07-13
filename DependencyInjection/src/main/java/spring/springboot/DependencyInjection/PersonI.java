package spring.springboot.DependencyInjection;

import org.springframework.stereotype.Service;

@Service
public interface PersonI {
    String getName();
    String getCity();
    Integer getAge();
    void setName(String name);
    void setCity(String city);
    void setAge(Integer age);
    String toString();
}
