package spring.springboot.PostgreDocker.Employee.domain;

import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.input.EmployeeInputDTO;
import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.output.EmployeeOutputDTO;

import java.util.List;

public interface IEmployee {
    List<EmployeeOutputDTO> getEmployees();
    EmployeeOutputDTO getEmployee(int id) throws RuntimeException;
    EmployeeOutputDTO postEmployee(EmployeeInputDTO employeeInputDTO);
    EmployeeOutputDTO putEmployee(int id, EmployeeInputDTO employeeInputDTO) throws RuntimeException;
    EmployeeOutputDTO deleteEmployee(int id) throws RuntimeException;
}
