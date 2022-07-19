package spring.springboot.AppConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/c1")
public class Controller {
    @Value("${VAR1}")
    String var1;
    @Value("${MY.VAR2}")
    String var2;
    @Value("${VAR3:'VAR3 doesnt have any value'}")
    String var3;

    @GetMapping("/values")
    public String getValues(){
        return "Value of VAR1 is " + var1 + " and value of MY.VAR2 is " + var2 + "\nValue of VAR3 is " + var3;
    }
}
