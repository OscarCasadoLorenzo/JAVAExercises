package com.rest.SpringBootExercise;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

@RestController("/c1")
public class Controller {
    @GetMapping("/user/{name}")
    String getHola(@PathVariable String name){
        return "Hola " + name;
    }

    @PostMapping("/useradd")
    Person newPerson(@RequestBody ObjectNode requestObject) {
        Person newPerson = new Person(requestObject.get("name").asText(), requestObject.get("city").asText(), requestObject.get("age").asText());
        newPerson.addOneYear();
        return newPerson;
    }

}
