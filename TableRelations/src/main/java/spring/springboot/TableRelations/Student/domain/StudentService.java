package spring.springboot.TableRelations.Student.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements StudentInterface{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentOutputDTO> getAllStudents() {
        return null;
    }

    @Override
    public StudentOutputDTO getStudentByID(String id) {
        return null;
    }

    @Override
    public StudentOutputDTO postStudent(StudentInputDTO studentInputDTO) {
        return null;
    }

    @Override
    public StudentOutputDTO updateStudent(String id, StudentInputDTO studentInputDTO) {
        return null;
    }

    @Override
    public StudentOutputDTO deleteStudent(String id) {
        return null;
    }
}
