package spring.springboot.TableRelations.Student.infraestructure.controller.dto.output;

import lombok.Getter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;

@Getter
public class SimpleStudentOutputDTO extends StudentOutputDTO{


    public SimpleStudentOutputDTO(StudentEntity studentEntity){
        super(studentEntity);
    }
}
