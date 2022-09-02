package spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TicketInputDTO {

    @NotBlank(message = "PersonID property is required.")
    @Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "PersonID property dont have correct syntax.")
    private String personID;

    @NotBlank(message = "TripID property is required.")
    private UUID tripID;
}
