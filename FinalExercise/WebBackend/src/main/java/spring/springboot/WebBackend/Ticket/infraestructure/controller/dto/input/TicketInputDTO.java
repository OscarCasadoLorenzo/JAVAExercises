package spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TicketInputDTO {

    @NotBlank(message = "PersonID property is required.")
    private UUID personID;

    @NotBlank(message = "TripID property is required.")
    private UUID tripID;
}
