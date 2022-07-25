package spring.springboot.TableRelations.Persona.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/*
    @ControllerAdvice tag extends @Component
    Is used for exception classes
 */
@RestControllerAdvice
public abstract class CustomizedResponseEntityExceptionHandler{


    /*
        - Not allowed to implement @ExceptionHandler to same classes
        - Not allowed to @Override super classes methods
     */

    // @ExceptionHandler tag execute this functions when BeanNotFoundException is threw
    @ExceptionHandler({NotFoundException.class, UnprocesableException.class})
    @Nullable
    public final ResponseEntity<CustomError> handleException(Exception ex, WebRequest request){
        if(ex instanceof NotFoundException subEx){
            CustomError customError = new CustomError(new Date(), ex.getMessage(), 404);
            return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
        }
        if(ex instanceof UnprocesableException subEx){
            CustomError customError = new CustomError(new Date(), ex.getMessage(), 422);
            return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else return null;
    }


}
