package spring.springboot.EnterpriseApplication.exceptions;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
