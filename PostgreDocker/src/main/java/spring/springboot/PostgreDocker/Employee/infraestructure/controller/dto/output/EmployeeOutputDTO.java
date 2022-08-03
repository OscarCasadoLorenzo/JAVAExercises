package spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.output;

import lombok.Data;
import spring.springboot.PostgreDocker.Employee.domain.Employee;


@Data
public class EmployeeOutputDTO {
    int id;
    String name;
    String department;

    public EmployeeOutputDTO(Employee employee){
        id = employee.getId();
        name = employee.getName();
        department = employee.getDepartment();
    }
}
