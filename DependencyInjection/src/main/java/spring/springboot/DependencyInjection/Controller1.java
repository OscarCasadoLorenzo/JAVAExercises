package spring.springboot.DependencyInjection;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("/c1")
public class Controller1
{
    @Autowired
    PersonService personService;

    @GetMapping("/controller1/addPerson")
    PersonService addPerson (@RequestHeader Map<String, String> headers){
        personService.setName(headers.get("name"));
        personService.setCity(headers.get("city"));
        personService.setAge(Integer.parseInt(headers.get("age")));

        return personService;
    }

    @PostMapping("/controller1/addCity")
    void addPerson (@RequestBody ObjectNode requestObject){
        String cityName = requestObject.get("cityName").asText();
        Integer cityPopulation = requestObject.get("cityPopulation").asInt();

        City newCity = new City(cityName, cityPopulation);
    }

}
