package spring.springboot.WebBackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.Optional;

/*
    @ControllerAdvice tag extends @Component
    Is used for exception classes
 */
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler{


    /*
        - Not allowed to implement @ExceptionHandler to same classes
        - Not allowed to @Override super classes methods
     */

    // @ExceptionHandler tag execute this functions when BeanNotFoundException is threw
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundCustomError> idNotFound(NotFoundException ex) {
        return new ResponseEntity<>(new NotFoundCustomError(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocesableException.class)
    public ResponseEntity<UnprocesableCustomError> invalidArguments(UnprocesableException ex) {
        UnprocesableCustomError unprocesableCustomError = new UnprocesableCustomError();

        unprocesableCustomError.setDniMismatch(ex.getMismatchedValidations().getFieldError("dni"));
        unprocesableCustomError.setEmailMismatch(ex.getMismatchedValidations().getFieldError("email"));
        unprocesableCustomError.setPasswordMismatch(ex.getMismatchedValidations().getFieldError("password"));
        unprocesableCustomError.setNameMismatch(ex.getMismatchedValidations().getFieldError("name"));
        unprocesableCustomError.setSurnameMismatch(ex.getMismatchedValidations().getFieldError("surname"));
        unprocesableCustomError.setPhoneMismatch(ex.getMismatchedValidations().getFieldError("phone"));

        return new ResponseEntity<>(unprocesableCustomError, HttpStatus.BAD_REQUEST);
    }
}



