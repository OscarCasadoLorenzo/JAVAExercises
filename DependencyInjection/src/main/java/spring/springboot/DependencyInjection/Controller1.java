package spring.springboot.DependencyInjection;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/controller1/addCity")
    void addPerson (@RequestBody ObjectNode requestObject){
        String cityName = requestObject.get("cityName").asText();
        Integer cityPopulation = requestObject.get("cityPopulation").asInt();

        City newCity = new City(cityName, cityPopulation);
    }

}
