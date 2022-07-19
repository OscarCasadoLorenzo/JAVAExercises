package spring.springboot.ProfilesConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/c1")
public class Controller {
    @Value("${URL}")
    String url;

    @Value("${PASSWORD}")
    String password;

    @Autowired
    ProfileInterface profileInterface;

    @GetMapping("/parameters")
    public String getDefaultParameters(){
        return "The URL is: " + url+ " and the password is : " + password;
    }

    @GetMapping("/myconfiguration")
    public String getMyParameters(){
        return null;
    }

    @GetMapping("/profile")
    public String getProfile(){
        return profileInterface.myFunction();
    }

}
