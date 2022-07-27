package spring.springboot.TableRelations.Subject.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output.SubjectOutputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService implements SubjectInterface{

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<SubjectOutputDTO> getAllSubjects() {
        return null;
    }

    @Override
    public SubjectOutputDTO getSubjectByID(int id, String outputType) {
        return null;
    }

    @Override
    public SubjectOutputDTO postSubject(SubjectInputDTO subjectInputDTO) {
        return null;
    }

    @Override
    public SubjectOutputDTO updateSubject(int id, SubjectInputDTO subjectInputDTO) {
        return null;
    }

    @Override
    public SubjectOutputDTO deleteSubject(int id) {
        return null;
    }
}
