package spring.springboot.WebBackend.Trip.infraestructure.controller.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TripInputDTO {

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    @NotBlank
    private Integer capacity;

    @NotBlank
    private Date date;

    @NotNull
    private Integer hour;
}
