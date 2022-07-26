package spring.springboot.TableRelations.Student.infraestructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class StudentOutputDTO {
    private Integer idStudent;
    private Integer numHoursWeek;
    private String comments;
    private String branch;
}
