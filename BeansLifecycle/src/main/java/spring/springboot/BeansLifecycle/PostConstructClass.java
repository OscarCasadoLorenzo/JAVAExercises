package spring.springboot.BeansLifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostConstructClass {

    //If line 7 where deleted, or @bean tag was used instead of it, the prompt wont sow the message. Why?
    @PostConstruct
    public void function1 (){
        System.out.println("I am initial class");
    }
}
