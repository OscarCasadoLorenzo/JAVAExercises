package spring.springboot.DependencyInjection;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("/c1")
public class Controller1
{
    @Autowired
    @Qualifier("standardBean")
    PersonService personService;

    @Autowired
    @Qualifier("bean1")
    PersonService personServiceBean1;

    @Autowired
    @Qualifier("bean2")
    PersonService personServiceBean2;

    @Autowired
    @Qualifier("bean3")
    PersonService personServiceBean3;

    @Autowired
    CityService cityService;

    @GetMapping("/controller1/addPerson")
    PersonService addPerson (@RequestHeader Map<String, String> headers){
        personService.setName(headers.get("name"));
        personService.setCity(headers.get("city"));
        personService.setAge(Integer.parseInt(headers.get("age")));

        return personService;
    }

    @PostMapping("/controller1/addCity")
    City addCity (@RequestBody ObjectNode requestObject){
        String cityName = requestObject.get("cityName").asText();
        Integer cityPopulation = requestObject.get("cityPopulation").asInt();

        City newCity = new City(cityName, cityPopulation);
        cityService.addCity(newCity);

        return newCity;
    }

    @GetMapping("/bean/{bean}")
    PersonService chooseBean (@PathVariable String bean){
        PersonService whichPersonService;
        switch (bean){
            case "bean1":
                whichPersonService = personServiceBean1;
                break;
            case "bean2":
                whichPersonService = personServiceBean2;
                break;
            case "bean3":
                whichPersonService = personServiceBean3;
                break;
            default:
                whichPersonService = personService;
        }

        return whichPersonService;
    }

}
