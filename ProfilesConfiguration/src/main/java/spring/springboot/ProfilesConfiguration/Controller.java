package spring.springboot.ProfilesConfiguration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:myconfiguration.properties")
})
@RestController("/c1")
public class Controller {
    @Value("${URL}")
    String url;

    @Value("${PASSWORD}")
    String password;

    @Value("${VALUE1}")
    String value1;

    @Value("${VALUE2}")
    String value2;

    @Autowired
    ProfileInterface profileInterface;

    @GetMapping("/parameters")
    public String getDefaultParameters(){
        return "The URL is: " + url+ " and the password is : " + password;
    }

    @GetMapping("/myconfiguration")
    public String getMyParameters(){
        return "The Value1 is: " + value1+ " and the Value2 is : " + value2;
    }

    @GetMapping("/profile")
    public String getProfile(){
        return profileInterface.myFunction();
    }

}
