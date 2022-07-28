package spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input;

import lombok.Getter;

@Getter
public class SubjectInputDTO {
    Integer teacherID;

    private String name;

    private String comment;
}
