package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class UnprocesableException extends RuntimeException{

    private BindingResult mismatchedValidations;

    public UnprocesableException(BindingResult mismatchedValidations) {
        super();
        this.mismatchedValidations = mismatchedValidations;
    }
}
