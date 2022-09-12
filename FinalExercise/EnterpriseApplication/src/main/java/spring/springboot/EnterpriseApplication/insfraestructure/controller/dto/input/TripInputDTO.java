package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class TripInputDTO {
    @NotBlank
    private String destination;

    @NotNull
    private Date date;

    @NotNull
    private Integer hour;
}
