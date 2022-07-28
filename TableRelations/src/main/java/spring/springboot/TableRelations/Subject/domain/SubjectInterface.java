package spring.springboot.TableRelations.Subject.domain;


import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output.SubjectOutputDTO;

import java.util.List;

public interface SubjectInterface {

    List<SubjectOutputDTO> getAllSubjects();

    SubjectOutputDTO addSubject(SubjectInputDTO subjectInputDTO);

    List<SubjectOutputDTO> getSubjectsByStudent(String id);

    List<SubjectOutputDTO> addSubjectsToStudent(List<SubjectInputDTO> newSubjects);

    List<SubjectOutputDTO> deleteSubjectsToStudent(List<SubjectEntity> oldSubjects);
}
