package spring.springboot.DependencyInjection;

import org.springframework.stereotype.Service;

@Service
public class PersonImpl implements PersonI{

    Person person = new Person("","","");

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public String getCity() {
        return person.getCity();
    }

    @Override
    public Integer getAge() {
        return person.getAge();
    }

    @Override
    public void setName(String name) {
        person.setName(name);
    }

    @Override
    public void setCity(String city) {
        person.setCity(city);
    }

    @Override
    public void setAge(Integer age) {
        person.setAge(age);
    }
}
