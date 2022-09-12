package spring.springboot.WebBackend.infraestructure.controller.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class TicketInputDTO {
    @NotNull(message = "PersonID property is required.")
    private Integer personID;

    @NotNull(message = "TripID property is required.")
    private Integer tripID;
}
