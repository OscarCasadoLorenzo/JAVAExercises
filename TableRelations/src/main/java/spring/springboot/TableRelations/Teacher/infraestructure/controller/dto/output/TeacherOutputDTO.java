package spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output;

import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

import java.util.List;

public class TeacherOutputDTO {
    private String coments;
    private String branch;

    private List<StudentOutputDTO> students;
    public TeacherOutputDTO(TeacherEntity teacherEntity){
        coments = teacherEntity.getComents();
        branch = teacherEntity.getBranch();
        //students
    }
}
