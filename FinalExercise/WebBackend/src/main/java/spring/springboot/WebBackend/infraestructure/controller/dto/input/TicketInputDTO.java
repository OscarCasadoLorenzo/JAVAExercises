package spring.springboot.WebBackend.infraestructure.controller.dto.input;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Getter
@Setter
public class TicketInputDTO {
    @NotBlank(message = "PersonID property is required.")
    private Integer personID;

    @NotBlank(message = "TripID property is required.")
    private Integer tripID;
}
