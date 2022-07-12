package com.rest.SpringBootExercise;

import org.springframework.web.bind.annotation.*;

@RestController("/c1")
public class Controller {
    @GetMapping("/user/{name}")
    String getHola(@PathVariable String name){
        return "Hola " + name;
    }

    @PostMapping("/useradd")
    Employee newEmployee(@RequestBody Person requestPerson) {
        return repository.save(newEmployee);
    }

}
