package spring.springboot.TableRelations.Subject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SUBJECTS")
@Getter
@Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherID")
    TeacherEntity teacher;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "STUDENTS_SUBJECTS",
            joinColumns = @JoinColumn(name = "subjectID"),
            inverseJoinColumns = @JoinColumn(name = "studentID")
    )
    List<StudentEntity> students = new ArrayList<>();

    String name;

    String comment;

    Date initial_date;

    Date finish_date;

    public SubjectEntity(){

    }

    public SubjectEntity(SubjectInputDTO subjectInputDTO){
        name = subjectInputDTO.getName();
        comment = subjectInputDTO.getComment();
    }

    public void enrollStudent(StudentEntity studentEntity){
        students.add(studentEntity);
    }
}
