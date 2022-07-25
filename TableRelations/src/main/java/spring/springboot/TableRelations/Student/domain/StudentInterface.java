package spring.springboot.TableRelations.Student.domain;

import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;

import java.util.List;

public interface StudentInterface {

    List<StudentOutputDTO> getAllStudents();

    StudentOutputDTO getStudentByID(String id);

    StudentOutputDTO postStudent(StudentInputDTO studentInputDTO);

    StudentOutputDTO updateStudent(String id, StudentInputDTO studentInputDTO);

    StudentOutputDTO deleteStudent(String id);
}
