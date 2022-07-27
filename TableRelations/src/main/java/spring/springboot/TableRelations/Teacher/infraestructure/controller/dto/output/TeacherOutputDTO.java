package spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output;

import lombok.Getter;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.output.PersonaOutputDTO;
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
    private PersonaOutputDTO personaOutputDTO;

    private List<StudentOutputDTO> students = new ArrayList<>();

    public TeacherOutputDTO(TeacherEntity teacherEntity){
        coments = teacherEntity.getComents();
        branch = teacherEntity.getBranch();
        personaOutputDTO  = new PersonaOutputDTO(teacherEntity.getPerson());
        for (StudentEntity studentEntity : teacherEntity.getStudents()){
            students.add(new SimpleStudentOutputDTO(studentEntity));
        }
    }
}
