package spring.springboot.TableRelations.Student.infraestructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;
import spring.springboot.TableRelations.Person.infraestructure.controller.dto.output.PersonaOutputDTO;
import spring.springboot.TableRelations.Student.domain.StudentEntity;

@Getter
@Setter
public class FullStudentOutputDTO extends StudentOutputDTO{

    private PersonaOutputDTO person;

    public FullStudentOutputDTO(StudentEntity studentEntity){
        super(studentEntity);
        this.setPerson(new PersonaOutputDTO(studentEntity.getPerson()));
    }
}
