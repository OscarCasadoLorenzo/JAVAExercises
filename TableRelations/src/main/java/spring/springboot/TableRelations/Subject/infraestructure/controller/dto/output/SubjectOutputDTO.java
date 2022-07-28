package spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output;

import lombok.Getter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Subject.domain.SubjectEntity;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
public class SubjectOutputDTO {

    private Integer id_study;

    private TeacherEntity teacher;

    private StudentEntity student;

    private String name;

    private String comment;

    private Date initial_date;

    private Date finish_date;

    public SubjectOutputDTO(){

    }

    public SubjectOutputDTO(SubjectEntity subjectEntity){
        id_study = subjectEntity.getId_study();
        teacher = subjectEntity.getTeacher();
       // student = subjectEntity.getStudent();
        name = subjectEntity.getName();
        comment = subjectEntity.getComment();
        initial_date = subjectEntity.getInitial_date();
        finish_date = subjectEntity.getFinish_date();
    }
}
