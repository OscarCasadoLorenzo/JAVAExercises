package spring.springboot.EnterpriseApplication.application.Token;

public interface TokenInterface {

    String getToken(String email, String password);

    void checkToken(String token);
}
