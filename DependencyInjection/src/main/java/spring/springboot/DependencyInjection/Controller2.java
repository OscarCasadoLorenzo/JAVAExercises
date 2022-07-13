package spring.springboot.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController ("c2")
public class Controller2
{
    @Autowired
    PersonI personI;

    @GetMapping("/controller2/getPerson")
    PersonI addPerson (){


        return personI;
    }
}
