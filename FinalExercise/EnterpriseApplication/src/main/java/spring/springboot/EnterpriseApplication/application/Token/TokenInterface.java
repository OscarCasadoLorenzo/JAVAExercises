package spring.springboot.EnterpriseApplication.application.Token;

public interface TokenInterface {

    String getToken(String user, String password);

    void checkToken(String token);
}
