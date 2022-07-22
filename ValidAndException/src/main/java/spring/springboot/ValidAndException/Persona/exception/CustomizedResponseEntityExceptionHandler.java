package spring.springboot.ValidAndException.Persona.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    /*
        - Not allowed to implement @ExceptionHandler to same classes
        - Not allowed to @Override super classes methods
     */

    // @ExceptionHandler tag execute this functions when BeanNotFoundException is threw
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(NotFoundException ex, WebRequest request) {
        CustomError customError = new CustomError(new Date(), ex.getMessage(), 404);
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    //@ExceptionHandler(UnprocesableException.class)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<CustomError> handleUnprocesableException(UnprocesableException ex, WebRequest request) {
        CustomError customError = new CustomError(new Date(), ex.getMessage(), 422);
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
