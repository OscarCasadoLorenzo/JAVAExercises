package spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TicketInputDTO {
    private String cityDestination;
    private Date date;
    private Integer hour;

    private String userName;
    private String userSurnames;
    private Integer phone;
    private String email;
}
