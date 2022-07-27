package spring.springboot.TableRelations.Teacher.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getTeacherByIDRoute(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(teacherService.getTeacherByID(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> postTeacherRoute(@RequestBody TeacherInputDTO teacherInputDTO){
        try{
            return new ResponseEntity<>(teacherService.postTeacher(teacherInputDTO), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public TeacherOutputDTO updateTeacherRoute(@PathVariable Integer id, @RequestBody TeacherInputDTO teacherInputDTO){
        return teacherService.updateTeacher(id, teacherInputDTO);
    }

    @DeleteMapping("/{id}")
    public TeacherOutputDTO deleteTeacherRoute(@PathVariable Integer id){
        return teacherService.deleteTeacher(id);
    }

}
