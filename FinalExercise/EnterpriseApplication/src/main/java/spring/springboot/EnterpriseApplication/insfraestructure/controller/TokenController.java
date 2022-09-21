package spring.springboot.EnterpriseApplication.insfraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springboot.EnterpriseApplication.application.Token.TokenService;

@RestController
@RequestMapping("api/backenterprise/token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @GetMapping
    public String getTokenRoute(
            @RequestHeader String email,
            @RequestHeader String password){
        return tokenService.getToken(email, password);
    }

    @GetMapping("/{token}")
    public void checkTokenRoute(
        @PathVariable String token
    ){
    }
}
