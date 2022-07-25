package spring.springboot.TableRelations.Teacher.domain;

import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;

import java.util.List;

public interface TeacherInterface {

    List<TeacherOutputDTO> getAllTeachers();

    TeacherOutputDTO getTeacherByID(String id);

    TeacherOutputDTO postTeacher(TeacherInputDTO teacherInputDTO);

    TeacherOutputDTO updateTeacher(String id, TeacherInputDTO teacherInputDTO);

    TeacherOutputDTO deleteTeacher(String id);
}
