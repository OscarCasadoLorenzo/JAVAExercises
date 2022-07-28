package spring.springboot.TableRelations.Student.infraestructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Subject.domain.SubjectEntity;

import java.util.List;

@Getter
@Setter
public abstract class StudentOutputDTO {
    private Integer idStudent;
    private Integer numHoursWeek;
    private String comments;
    private String branch;
    private List<SubjectEntity> subjects;

    public StudentOutputDTO(StudentEntity studentEntity){
        if (studentEntity == null)
            return;

        this.setIdStudent(studentEntity.getId());
        this.setNumHoursWeek(studentEntity.getNum_hours_week());
        this.setComments(studentEntity.getComents());
        this.setBranch(studentEntity.getBranch());
        this.setSubjects(studentEntity.getSubjects());
    }
}
