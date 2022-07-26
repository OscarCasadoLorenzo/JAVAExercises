package spring.springboot.TableRelations.Teacher.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springboot.TableRelations.Teacher.domain.TeacherService;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.input.TeacherInputDTO;
import spring.springboot.TableRelations.Teacher.infraestructure.controller.dto.output.TeacherOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public List<TeacherOutputDTO> getAllTeachersRoute(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherOutputDTO getTeacherByIDRoute(@PathVariable String id){
        return teacherService.getTeacherByID(id);
    }

    @PostMapping
    public TeacherOutputDTO postTeacherRoute(@RequestBody TeacherInputDTO teacherInputDTO){
        return teacherService.postTeacher(teacherInputDTO);
    }

    @PutMapping("/{id}")
    public TeacherOutputDTO updateTeacherRoute(@PathVariable String id, @RequestBody TeacherInputDTO teacherInputDTO){
        return teacherService.updateTeacher(id, teacherInputDTO);
    }

    @DeleteMapping("/{id}")
    public TeacherOutputDTO deleteTeacherRoute(@PathVariable String id){
        return teacherService.deleteTeacher(id);
    }

}
