package spring.springboot.TableRelations.Teacher.domain;

import lombok.Data;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Student.domain.StudentEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @ManyToOne
    @JoinColumn(name = "studentID")
    StudentEntity student;

    @Column
    String coments;

    @Column @NotNull
    String branch;
}
