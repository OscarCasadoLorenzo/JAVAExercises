package spring.springboot.PostgreDocker.Employee.infraestructure.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springboot.PostgreDocker.Employee.domain.EmployeeService;
import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.input.EmployeeInputDTO;
import spring.springboot.PostgreDocker.Employee.infraestructure.controller.dto.output.EmployeeOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<EmployeeOutputDTO> getEmployeesRoute(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeOutputDTO getEmployeeRoute(@PathVariable int id) throws RuntimeException{
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public EmployeeOutputDTO postEmployeeRoute(@RequestBody EmployeeInputDTO employeeInputDTO){
        return employeeService.postEmployee(employeeInputDTO);
    }

    @PutMapping("/{id}")
    public EmployeeOutputDTO putEmployeeRoute(@PathVariable int id, @RequestBody EmployeeInputDTO employeeInputDTO) throws RuntimeException{
        return employeeService.putEmployee(id, employeeInputDTO);
    }

    @DeleteMapping("/{id}")
    public EmployeeOutputDTO deleteEmployeeRoute(@PathVariable int id) throws RuntimeException{
        return employeeService.deleteEmployee(id);
    }
}
