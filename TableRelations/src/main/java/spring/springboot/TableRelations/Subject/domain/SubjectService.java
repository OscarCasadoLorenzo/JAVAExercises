package spring.springboot.TableRelations.Subject.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.FullStudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;
import spring.springboot.TableRelations.Student.infraestructure.repository.StudentRepository;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectsIdsInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output.SubjectOutputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.repository.SubjectRepository;
import spring.springboot.TableRelations.Teacher.domain.TeacherEntity;
import spring.springboot.TableRelations.Teacher.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService implements SubjectInterface{

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public List<SubjectOutputDTO> getAllSubjects() {
        List<SubjectOutputDTO> subjectOutputDTOList = new ArrayList<>();
        for(SubjectEntity subjectEntity : subjectRepository.findAll()){
            subjectOutputDTOList.add(new SubjectOutputDTO(subjectEntity));
        }
        return  subjectOutputDTOList;
    }

    @Override
    public SubjectOutputDTO addSubject(SubjectInputDTO subjectInputDTO) {
        TeacherEntity teacherEntity = teacherRepository.findById(subjectInputDTO.getTeacherID()).orElse(null);
        if(teacherEntity == null)
            throw new RuntimeException("Subject must have a property teacher reference");

        SubjectEntity subjectEntity = new SubjectEntity(subjectInputDTO, teacherEntity);
        subjectRepository.save(subjectEntity);
        return new SubjectOutputDTO(subjectEntity);
    }

    @Override
    public List<SubjectOutputDTO> getSubjectsByStudent(String id) {

        List<SubjectOutputDTO> subjectOutputDTOList = new ArrayList<>();
        for(SubjectEntity subjectEntity : subjectRepository.findSubjectsByStudent(id)){
            subjectOutputDTOList.add(new SubjectOutputDTO(subjectEntity));
        }
        return subjectOutputDTOList;
    }

    @Override
    public StudentOutputDTO addSubjectsToStudent(SubjectsIdsInputDTO subjectsIdsInputDTO, String studentID) {
        //Take Student
        StudentEntity studentEntity = studentRepository.findById(Integer.parseInt(studentID)).get();


        //Take Subjects
        for (int subjectID : subjectsIdsInputDTO.getSubjects()){
            SubjectEntity subjectEntity = subjectRepository.findById(subjectID).get();
            subjectEntity.enrollStudent(studentEntity);
            subjectRepository.save(subjectEntity);
        }

        return new FullStudentOutputDTO(studentEntity);
    }

    @Override
    public List<SubjectOutputDTO> deleteSubjectsToStudent(List<SubjectEntity> oldSubjects) {
        return null;
    }
}
