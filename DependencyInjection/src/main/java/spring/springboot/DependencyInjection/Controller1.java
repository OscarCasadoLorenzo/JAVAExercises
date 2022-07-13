package spring.springboot.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/c1")
public class Controller1
{
    @Autowired
    PersonI personI;

    @GetMapping("/controller1/addPerson")
    PersonI addPerson (@RequestHeader Map<String, String> headers){
        personI.setName(headers.get("name"));
        personI.setCity(headers.get("city"));
        personI.setAge(Integer.parseInt(headers.get("age")));

        return personI;
    }
}
