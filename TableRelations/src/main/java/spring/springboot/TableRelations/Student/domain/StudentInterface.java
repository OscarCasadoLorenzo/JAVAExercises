package spring.springboot.TableRelations.Student.domain;

import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.FullStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.SimpleStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;

import java.util.List;

public interface StudentInterface {

    List<SimpleStudentOutputDTO> getAllStudents();

    StudentOutputDTO getStudentByID(int id, String outputType);

    FullStudentOutputDTO postStudent(StudentInputDTO studentInputDTO);

    StudentEntity updateStudent(int id, StudentInputDTO studentInputDTO);

    StudentEntity deleteStudent(int id);
}
