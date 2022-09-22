package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class UnprocesableException extends RuntimeException{

    private BindingResult mismatchedValidations;
    private String controllerRoot;

    public UnprocesableException(BindingResult mismatchedValidations, String controllerRoot ) {
        super();
        this.mismatchedValidations = mismatchedValidations;
        this.controllerRoot = controllerRoot;
    }
}
