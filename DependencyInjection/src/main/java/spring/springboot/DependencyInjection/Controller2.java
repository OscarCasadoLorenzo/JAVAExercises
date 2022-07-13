package spring.springboot.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController ("/c2")
public class Controller2
{
    @Autowired
    PersonI personI;

    @GetMapping("/controller2/getPerson")
    PersonI addPerson (){
        personI.setAge(personI.getAge()*2);
        return personI;
    }
    @GetMapping("/controller2/getCitys")
    List<City> getCities (){

    }

}
