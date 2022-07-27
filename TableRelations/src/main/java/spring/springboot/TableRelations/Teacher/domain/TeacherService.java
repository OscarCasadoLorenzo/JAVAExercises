package spring.springboot.TableRelations.Teacher.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;
import spring.springboot.TableRelations.Teacher.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherService implements TeacherInterface{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<TeacherOutputDTO> getAllTeachers() {
        List<TeacherOutputDTO> teacherOutputDTOList = null;
        for(TeacherEntity teacherEntity : teacherRepository.findAll()){
            teacherOutputDTOList.add(new TeacherOutputDTO(teacherEntity));
        }
        return teacherOutputDTOList;
    }

    @Override
    public TeacherOutputDTO getTeacherByID(String id) {
        TeacherOutputDTO teacherOutputDTO = new TeacherOutputDTO(teacherRepository.findById(id).orElse(null));
        return teacherOutputDTO;
    }

    @Override
    public TeacherOutputDTO postTeacher(TeacherInputDTO teacherInputDTO) {
        System.out.println(teacherInputDTO.getStudentsIDs());
        return null;
    }

    @Override
    public TeacherOutputDTO updateTeacher(String id, TeacherInputDTO teacherInputDTO) {
        return null;
    }

    @Override
    public TeacherOutputDTO deleteTeacher(String id) {
        return null;
    }
}
