package spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input;

import lombok.Data;
import lombok.Getter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
public class SubjectInputDTO {

    //TeacherEntity teacher;

    //List<StudentEntity> students;

    private String name;

    private String comment;

}
