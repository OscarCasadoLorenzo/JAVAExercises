package spring.springboot.TableRelations.Teacher.domain;

import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;

import java.util.List;

public interface TeacherInterface {

    List<TeacherOutputDTO> getAllTeachers();

    TeacherOutputDTO getTeacherByID(Integer id);

    TeacherOutputDTO postTeacher(TeacherInputDTO teacherInputDTO);

    TeacherOutputDTO updateTeacher(Integer id, TeacherInputDTO teacherInputDTO);

    TeacherOutputDTO deleteTeacher(Integer id);
}
