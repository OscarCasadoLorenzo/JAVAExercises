package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
public class UnprocesableTripCustomError {

    private String destinationMismatch;
    private String dateMismatch;
    private String hourMismatch;

    public UnprocesableTripCustomError(BindingResult bindingResult) {
        this.destinationMismatch = bindingResult.getFieldError("destination").getDefaultMessage();
        this.dateMismatch = bindingResult.getFieldError("date").getDefaultMessage();
        this.hourMismatch = bindingResult.getFieldError("hour").getDefaultMessage();
    }
}
