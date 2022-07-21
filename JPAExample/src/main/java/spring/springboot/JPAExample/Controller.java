package spring.springboot.JPAExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/probe")
    public String getProbe(){
        return "Probe string";
    }

    @PostMapping("/user")
    public Usuario postUser(@RequestBody Usuario user){
        userRepository.save(user);
        return user;
    }

    @GetMapping("/users")
    public List<Usuario> getUsers(){
        return userRepository.findAll();
    }
}
