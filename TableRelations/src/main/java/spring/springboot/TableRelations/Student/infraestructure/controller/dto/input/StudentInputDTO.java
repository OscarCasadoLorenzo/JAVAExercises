package spring.springboot.TableRelations.Student.infraestructure.controller.dto.input;

import lombok.Getter;

@Getter
public class StudentInputDTO {
    private int personID;

    private Integer num_hours_week;

    private String coments;

    private String branch;
}
