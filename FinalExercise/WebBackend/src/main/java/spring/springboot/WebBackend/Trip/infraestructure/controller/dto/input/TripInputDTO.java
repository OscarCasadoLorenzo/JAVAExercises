package spring.springboot.WebBackend.Trip.infraestructure.controller.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class TripInputDTO {

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    @NotNull
    private Integer capacity;

    @NotNull
    private Date date;

    @NotNull
    private Integer hour;
}
