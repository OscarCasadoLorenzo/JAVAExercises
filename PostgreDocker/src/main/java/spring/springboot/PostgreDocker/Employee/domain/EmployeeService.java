package spring.springboot.PostgreDocker.Employee.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.input.EmployeeInputDTO;
import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.output.EmployeeOutputDTO;
import spring.springboot.PostgreDocker.Employee.infraestructure.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployee{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeOutputDTO> getEmployees() {
        List<EmployeeOutputDTO> employeeOutputDTOList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()){
            employeeOutputDTOList.add(new EmployeeOutputDTO(employee));
        }

        return employeeOutputDTOList;
    }

    @Override
    public EmployeeOutputDTO getEmployee(int id) {
        if(!employeeRepository.existsById(id))
            throw new RuntimeException("Employee with id: " + id + "does not exists.");

        return new EmployeeOutputDTO(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeOutputDTO postEmployee(EmployeeInputDTO employeeInputDTO) {
        Employee newEmployee = new Employee(employeeInputDTO);
        employeeRepository.save(newEmployee);

        return new EmployeeOutputDTO(newEmployee);
    }

    @Override
    public EmployeeOutputDTO putEmployee(int id, EmployeeInputDTO employeeInputDTO) {
        if(!employeeRepository.existsById(id))
            throw new RuntimeException("Employee with id: " + id + "does not exists.");
        Employee updatedEmployee = employeeRepository.findById(id).get();
        updatedEmployee.setName(employeeInputDTO.getName());
        updatedEmployee.setDepartment(employeeInputDTO.getDepartment());

        return new EmployeeOutputDTO(updatedEmployee);
    }

    @Override
    public EmployeeOutputDTO deleteEmployee(int id) {
        if(!employeeRepository.existsById(id))
            throw new RuntimeException("Employee with id: " + id + "does not exists.");

        Employee deletedEmployee = employeeRepository.findById(id).get():
        employeeRepository.deleteById(id);
        return new EmployeeOutputDTO(deletedEmployee);
    }
}
