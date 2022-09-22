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
    public ResponseEntity invalidArguments(UnprocesableException ex) {
        switch (ex.getControllerRoot()){
            case "Person":
                UnprocesablePersonCustomError unprocesablePersonCustomError = new UnprocesablePersonCustomError(ex.getMismatchedValidations());
                return new ResponseEntity<>(unprocesablePersonCustomError, HttpStatus.BAD_REQUEST);

            case "Trip":
                UnprocesableTripCustomError unprocesableTripCustomError = new UnprocesableTripCustomError(ex.getMismatchedValidations());
                return new ResponseEntity<>(unprocesableTripCustomError, HttpStatus.BAD_REQUEST);

            case "Ticket":
                UnprocesableTicketCustomError unprocesableTicketCustomError = new UnprocesableTicketCustomError(ex.getMismatchedValidations());
                return new ResponseEntity<>(unprocesableTicketCustomError, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @ExceptionHandler(FullCapacityException.class)
    public ResponseEntity<String> tripCapacityIsZero(FullCapacityException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}



