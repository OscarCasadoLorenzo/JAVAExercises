package spring.springboot.TableRelations.Student.domain;

import lombok.Data;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
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
    @JoinColumn
    PersonEntity person;

    @Column
    @NotNull
    Integer num_hours_week;

    @Column
    String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    TeacherEntity teacher;

    @Column
    String branch;

    @ManyToMany
    List<Alumnos_Estudios> estudios;
}
