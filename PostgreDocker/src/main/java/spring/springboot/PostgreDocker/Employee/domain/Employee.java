package spring.springboot.PostgreDocker.Employee.domain;

import lombok.Data;
import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.input.EmployeeInputDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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
