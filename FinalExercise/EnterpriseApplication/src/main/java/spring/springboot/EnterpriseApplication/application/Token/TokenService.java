package spring.springboot.EnterpriseApplication.application.Token;

import org.springframework.stereotype.Service;

@Service
public class TokenService implements TokenInterface{
    @Override
    public String getToken(String user, String password) {
        return null;
    }

    @Override
    public void chekToken(String token) {

    }
}
