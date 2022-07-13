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
    PersonI addPerson listHeaders(@RequestHeader Map<String, String> headers){

    }
}
