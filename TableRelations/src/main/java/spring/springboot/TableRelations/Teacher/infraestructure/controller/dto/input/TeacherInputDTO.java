package spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input;

import lombok.Getter;

import java.util.List;

@Getter
public class TeacherInputDTO {
    private String coments;
    private String branch;

    private List<Integer> studentsIDs;
}
