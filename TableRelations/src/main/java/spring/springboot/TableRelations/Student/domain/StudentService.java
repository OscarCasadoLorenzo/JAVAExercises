package spring.springboot.TableRelations.Student.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Person.infraestructure.repository.jpa.PersonRepository;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.FullStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.SimpleStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.repository.StudentRepository;
import spring.springboot.TableRelations.Teacher.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentInterface{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<SimpleStudentOutputDTO> getAllStudents() {
        List<SimpleStudentOutputDTO> simpleStudentOutputDTOS = new ArrayList<>();

        for (StudentEntity studentEntity : studentRepository.findAll()){
            simpleStudentOutputDTOS.add(new SimpleStudentOutputDTO(studentEntity));
        }

        return simpleStudentOutputDTOS;
    }

    @Override
    public StudentOutputDTO getStudentByID(int id, String outputType) {
        if(!studentRepository.existsById(id))
            throw new RuntimeException("Student with id: " + id + " doesnt exists.");

        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        StudentOutputDTO studentOutputDTO;

       if(outputType.equals("full"))
           studentOutputDTO = new FullStudentOutputDTO(studentEntity);
       else  studentOutputDTO = new SimpleStudentOutputDTO(studentEntity);

       return  studentOutputDTO;
    }

    @Override
    public FullStudentOutputDTO postStudent(StudentInputDTO studentInputDTO) {
        //Check if personID is being used for other student
        /*
        if(studentRepository.isPersonIDBeingUsedByOtherStudent(studentInputDTO.getPersonID()) == null)
            throw new RuntimeException("MENUDA LIADA");
         */


        //We need to recover the PersonEntity linked to the InputDTO's personID
        PersonEntity personEntity = personRepository.findById(studentInputDTO.getPersonID()).orElse(null);
        if (personEntity==null ||
                studentRepository.getPersonQuery(studentInputDTO.getPersonID()) != null ||
                teacherRepository.getPersonQuery(studentInputDTO.getPersonID()) != null
        )
            throw new RuntimeException("Student object must have a correct person reference.");

        StudentEntity studentEntity = new StudentEntity(studentInputDTO, personEntity);
        studentRepository.save(studentEntity);
        return new FullStudentOutputDTO(studentEntity);
    }

    @Override
    public StudentEntity updateStudent(int id, StudentInputDTO studentInputDTO) {
        return null;
    }

    @Override
    public StudentEntity deleteStudent(int id) {
        return null;
    }
}
