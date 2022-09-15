package spring.springboot.EnterpriseApplication.insfraestructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.HeaderParam;

@RestController
@RequestMapping("api/v0/token")
public class TokenController {

    @GetMapping
    public String getTokenRoute(
            @RequestHeader String user,
            @RequestHeader String password){

    }
}
