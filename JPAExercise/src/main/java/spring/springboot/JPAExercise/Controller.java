package spring.springboot.JPAExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/probe")
    public String probe(){
        return "Probe string";
    }
}
