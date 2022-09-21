package spring.springboot.EnterpriseApplication.application.Token;

import org.springframework.http.ResponseEntity;

public interface TokenInterface {

    String getToken(String email, String password);

    ResponseEntity checkToken(String token);
}
