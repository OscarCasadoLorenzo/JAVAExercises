package spring.springboot.TableRelations.Teacher.domain;

import lombok.Data;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Subject.domain.SubjectEntity;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
@Data
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToOne
    @JoinColumn(name = "personID")
    PersonEntity person;

    @OneToMany
    @JoinColumn(name = "subjectID")
    List<SubjectEntity>  subjects;

    @Column
    String coments;

    @Column @NotNull
    String branch;

    public TeacherEntity(){

    }

    public TeacherEntity(TeacherInputDTO teacherInputDTO, PersonEntity personEntity){
        coments = teacherInputDTO.getComents();
        branch = teacherInputDTO.getBranch();
        person = personEntity;
    }
}
