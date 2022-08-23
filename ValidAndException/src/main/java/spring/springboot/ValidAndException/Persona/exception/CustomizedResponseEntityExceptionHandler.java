package spring.springboot.ValidAndException.Persona.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
    public ResponseEntity<CustomError> idNotFound(NotFoundException ex) {
        return new ResponseEntity<>(new CustomError(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocesableException.class)
    public ResponseEntity<CustomError> invalidArguments(UnprocesableException ex) {
        return new ResponseEntity<>(new CustomError(new Date(), ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}



