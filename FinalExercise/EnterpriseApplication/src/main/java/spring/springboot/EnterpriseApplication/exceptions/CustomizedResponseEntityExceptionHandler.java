package spring.springboot.EnterpriseApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

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
    public ResponseEntity<UnprocesableTicketCustomError> invalidArguments(UnprocesableException ex) {
        UnprocesableTicketCustomError unprocesableTicketCustomError = new UnprocesableTicketCustomError();

        unprocesableTicketCustomError.setDniMismatch(ex.getMismatchedValidations().getFieldError("dni"));
        unprocesableTicketCustomError.setEmailMismatch(ex.getMismatchedValidations().getFieldError("email"));
        unprocesableTicketCustomError.setPasswordMismatch(ex.getMismatchedValidations().getFieldError("password"));
        unprocesableTicketCustomError.setNameMismatch(ex.getMismatchedValidations().getFieldError("name"));
        unprocesableTicketCustomError.setSurnameMismatch(ex.getMismatchedValidations().getFieldError("surname"));
        unprocesableTicketCustomError.setPhoneMismatch(ex.getMismatchedValidations().getFieldError("phone"));

        return new ResponseEntity<>(unprocesableTicketCustomError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FullCapacityException.class)
    public ResponseEntity<String> tripCapacityIsZero(FullCapacityException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}



