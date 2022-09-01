package spring.springboot.WebBackend.exceptions;

import org.springframework.validation.BindingResult;

public class UnprocesableException extends RuntimeException{

    public UnprocesableException(BindingResult mismatchedValidations) {

    }
}
