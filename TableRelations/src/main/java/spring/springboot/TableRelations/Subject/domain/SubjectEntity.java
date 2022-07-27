package spring.springboot.TableRelations.Subject.domain;

import lombok.Getter;
import lombok.Setter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SUBJECTS")
@Getter
@Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherID")
    TeacherEntity teacher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentID")
    StudentEntity student;

    String name;

    String comment;

    Date initial_date;

    Date finish_date;
}
