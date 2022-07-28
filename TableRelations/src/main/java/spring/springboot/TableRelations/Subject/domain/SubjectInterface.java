package spring.springboot.TableRelations.Subject.domain;


import spring.springboot.TableRelations.Student.infraestructure.controller.dto.output.StudentOutputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.input.SubjectsIdsInputDTO;
import spring.springboot.TableRelations.Subject.infraestructure.controller.dto.output.SubjectOutputDTO;

import java.util.List;

public interface SubjectInterface {

    List<SubjectOutputDTO> getAllSubjects();

    SubjectOutputDTO addSubject(SubjectInputDTO subjectInputDTO);

    List<SubjectOutputDTO> getSubjectsByStudent(String id);

    StudentOutputDTO addSubjectsToStudent(SubjectsIdsInputDTO subjectsIdsInputDTO, String studentID);

    List<SubjectOutputDTO> deleteSubjectsToStudent(List<SubjectEntity> oldSubjects);
}
