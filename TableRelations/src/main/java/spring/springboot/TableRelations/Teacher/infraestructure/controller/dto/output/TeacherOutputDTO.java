package spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output;

import lombok.Getter;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.SimpleStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TeacherOutputDTO {
    private String coments;
    private String branch;

    private List<StudentOutputDTO> students = new ArrayList<>();
    public TeacherOutputDTO(TeacherEntity teacherEntity){
        coments = teacherEntity.getComents();
        branch = teacherEntity.getBranch();

        for (StudentEntity studentEntity : teacherEntity.getStudents()){
            students.add(new SimpleStudentOutputDTO(studentEntity));
        }
    }
}
