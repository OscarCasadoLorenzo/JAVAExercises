package spring.springboot.TableRelations.Subject.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Student.domain.StudentEntity;
import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.FullStudentOutputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output.SubjectOutputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService implements SubjectInterface{

    @Autowired
    SubjectRepository subjectRepository;


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
        SubjectEntity subjectEntity = new SubjectEntity(subjectInputDTO);
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
    public List<SubjectOutputDTO> addSubjectsToStudent(List<SubjectInputDTO> newSubjects) {
        return null;
    }

    @Override
    public List<SubjectOutputDTO> deleteSubjectsToStudent(List<SubjectEntity> oldSubjects) {
        return null;
    }
}
