package spring.springboot.TableRelations.Subject.infraestructure.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springboot.TableRelations.Subject.domain.SubjectService;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output.SubjectOutputDTO;

import javax.security.auth.Subject;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<SubjectOutputDTO> getAllSubjectsRoute(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public SubjectOutputDTO addSubjectRoute(@RequestBody SubjectInputDTO subjectInputDTO){
        return subjectService.addSubject(subjectInputDTO);
    }

    @GetMapping("{id}")
    public List<SubjectOutputDTO> getSubjectsOfStudentRoute(@PathVariable String id){
        return subjectService.getSubjectsByStudent(id);
    }
}
