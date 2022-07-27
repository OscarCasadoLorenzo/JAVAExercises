package spring.springboot.TableRelations.Teacher.domain;

import lombok.Data;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
@Data
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String id;

    @OneToOne
    @JoinColumn(name = "personID")
    PersonEntity person;

    @OneToMany
    @JoinColumn(name = "studentID")
    List<StudentEntity> students;

    @Column
    String coments;

    @Column @NotNull
    String branch;

    public TeacherEntity(TeacherInputDTO teacherInputDTO, List<StudentEntity> studentsList){
        coments = teacherInputDTO.getComents();
        branch = teacherInputDTO.getBranch();
        students = studentsList;
    }
}
