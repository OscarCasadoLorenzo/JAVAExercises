package spring.springboot.TableRelations.Student.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springboot.TableRelations.Student.domain.StudentService;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.input.StudentInputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentOutputDTO> getAllStudentsRoute(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentOutputDTO getStudentByIDRoute(@PathVariable String id){
        return studentService.getStudentByID(id);
    }

    @PostMapping
    public StudentOutputDTO postStudentRoute(@RequestBody StudentInputDTO studentInputDTO){
        return studentService.postStudent(studentInputDTO);
    }

    @PutMapping("/{id}")
    public StudentOutputDTO updateStudentRoute(@PathVariable String id, @RequestBody StudentInputDTO studentInputDTO){
        return studentService.updateStudent(id, studentInputDTO);
    }

    @DeleteMapping("/{id}")
    public StudentOutputDTO deleteStudentRoute(@PathVariable String id){
        return studentService.deleteStudent(id);
    }
}
