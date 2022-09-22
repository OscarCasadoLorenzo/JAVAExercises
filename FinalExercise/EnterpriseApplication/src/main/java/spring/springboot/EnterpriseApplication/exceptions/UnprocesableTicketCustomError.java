package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class UnprocesableTicketCustomError {

    private String personIDMismatch;
    private String tripIDMismatch;

    public UnprocesableTicketCustomError(BindingResult bindingResult) {
        this.personIDMismatch = bindingResult.getFieldError("personID").getDefaultMessage();
        this.tripIDMismatch = bindingResult.getFieldError("tripID").getDefaultMessage();
    }
}
