package spring.springboot.TableRelations.Teacher.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Person.domain.PersonEntity;
import spring.springboot.TableRelations.Person.infraestructure.repository.jpa.PersonRepository;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Student.infraestructure.repository.StudentRepository;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;
import spring.springboot.TableRelations.Teacher.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherInterface{

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<TeacherOutputDTO> getAllTeachers() {
        List<TeacherOutputDTO> teacherOutputDTOList = null;
        for(TeacherEntity teacherEntity : teacherRepository.findAll()){
            teacherOutputDTOList.add(new TeacherOutputDTO(teacherEntity));
        }
        return teacherOutputDTOList;
    }

    @Override
    public TeacherOutputDTO getTeacherByID(Integer id) {
        if(!teacherRepository.existsById(id))
            throw new RuntimeException("Teacher with id: " + id + " doesnt exists.");

        TeacherOutputDTO teacherOutputDTO = new TeacherOutputDTO(teacherRepository.findById(id).orElse(null));
        return teacherOutputDTO;
    }

    @Override
    public TeacherOutputDTO postTeacher(TeacherInputDTO teacherInputDTO) throws  RuntimeException{
        PersonEntity personEntity = personRepository.findById(teacherInputDTO.getPersonID()).orElse(null);

        //Check if exists all the students and create a list with them
        List<StudentEntity> studentEntityList = new ArrayList<>();
        teacherInputDTO.getStudentsIDs().stream().forEach(
                id -> {
                    if(!studentRepository.existsById(id))
                        throw new RuntimeException("Student with id: " + id + " doesnt exists.");
                    studentEntityList.add(studentRepository.findById(id).get());
                }
        );

        TeacherEntity teacherEntity = new TeacherEntity(teacherInputDTO, personEntity, studentEntityList);
        teacherRepository.save(teacherEntity);

        return new TeacherOutputDTO(teacherEntity);
    }

    @Override
    public TeacherOutputDTO updateTeacher(Integer id, TeacherInputDTO teacherInputDTO) {
        return null;
    }

    @Override
    public TeacherOutputDTO deleteTeacher(Integer id) {
        return null;
    }
}
