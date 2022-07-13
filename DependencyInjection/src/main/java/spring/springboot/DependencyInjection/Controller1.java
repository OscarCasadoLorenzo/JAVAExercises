package spring.springboot.DependencyInjection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/c1")
public class Controller1
{
    @GetMapping("/controller1/addPerson")

}
