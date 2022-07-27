package spring.springboot.TableRelations.Subject.domain;


import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output.SubjectOutputDTO;

import java.util.List;

public interface SubjectInterface {

    List<SubjectOutputDTO> getAllSubjects();

    SubjectOutputDTO getSubjectByID(int id, String outputType);

    SubjectOutputDTO postSubject(SubjectInputDTO subjectInputDTO);

    SubjectOutputDTO updateSubject(int id, SubjectInputDTO subjectInputDTO);

    SubjectOutputDTO deleteSubject(int id);
}
