package spring.springboot.PostgreDocker.Employee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.input.EmployeeInputDTO;

import javax.persistence.*;
@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;

    String department;

    public Employee (EmployeeInputDTO employeeInputDTO){
        name = employeeInputDTO.getName();
        department = employeeInputDTO.getDepartment();
    }
}
