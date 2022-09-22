package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
public class UnprocesableTripCustomError {

    private String destination;
    private String date;
    private String hour;

    public void setDestination(FieldError destinationMismatch) {
        if(destinationMismatch != null)
            this.destination = destinationMismatch.getDefaultMessage();
    }

    public void setDate(FieldError dateMismatch) {
        if(dateMismatch != null)
            this.date = dateMismatch.getDefaultMessage();
    }

    public void setHour(FieldError hourMismatch) {
        if(hourMismatch != null)
            this.hour = hourMismatch.getDefaultMessage();
    }
}
