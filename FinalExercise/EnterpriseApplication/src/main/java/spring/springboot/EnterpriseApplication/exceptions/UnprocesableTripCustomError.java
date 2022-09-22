package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
public class UnprocesableTripCustomError {

    private String destination;
    private Date date;
    private Integer hour;
}
