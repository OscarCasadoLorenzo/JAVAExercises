package spring.springboot.TableRelations.Student.infraestructure.controller.dto.output;

import lombok.Getter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;

@Getter
public class SimpleStudentOutputDTO extends StudentOutputDTO{


    public SimpleStudentOutputDTO(StudentEntity studentEntity){
        if (studentEntity == null)
            return;

        this.setIdStudent(studentEntity.getId());
        this.setNumHoursWeek(studentEntity.getNum_hours_week());
        this.setComments(studentEntity.getComents());
        this.setBranch(studentEntity.getBranch());
    }
}
