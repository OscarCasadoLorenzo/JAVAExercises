package spring.springboot.TableRelations.Student.domain;

import lombok.Data;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "STUDENTS")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @OneToOne
    @JoinColumn(name = "personID")
    PersonEntity person;

    /*  INCORRECT COLLECTION DECLARATION IN RELATIONSHIPS
         @ManyToMany
         private Teacher teacher;

         @OneToMany
         private Teacher teacher;

         @OneToOne
         private List<Teacher> teachers;

         @ManyToOne
         private List<Teacher> teachers;
     */
    @ManyToOne
    @JoinColumn(name= "teacherID")
    TeacherEntity teacher;

    @Column
    @NotNull
    Integer num_hours_week;

    @Column
    String coments;

    @Column
    String branch;

    public StudentEntity(){

    }

    public StudentEntity(StudentInputDTO studentInputDTO, PersonEntity personEntity){
        if (studentInputDTO == null)
            return;

        num_hours_week = studentInputDTO.getNum_hours_week();
        coments = studentInputDTO.getComents();
        branch = studentInputDTO.getBranch();
        person = personEntity;
    }
}
