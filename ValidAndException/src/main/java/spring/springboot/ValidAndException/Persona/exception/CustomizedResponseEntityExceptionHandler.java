package spring.springboot.ValidAndException.Persona.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    // @ExceptionHandler tag execute this functions when BeanNotFoundException is thrown
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(NotFoundException ex, WebRequest request) {
        CustomError customError = new CustomError(new Date(), ex.getMessage(), 404);
        return new ResponseEntity<CustomError>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<CustomError> handleUnprocesableException(NotFoundException ex, WebRequest request) {
        CustomError customError = new CustomError(new Date(), ex.getMessage(), 422);
        return new ResponseEntity<CustomError>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
