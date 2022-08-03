package spring.springboot.PostgreDocker.Employee.infraestructure.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getEmployeeRoute(@PathVariable int id){
        try{
            return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK) ;
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND) ;
        }
    }

    @PostMapping
    public EmployeeOutputDTO postEmployeeRoute(@RequestBody EmployeeInputDTO employeeInputDTO){
        return employeeService.postEmployee(employeeInputDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putEmployeeRoute(@PathVariable int id, @RequestBody EmployeeInputDTO employeeInputDTO) throws RuntimeException{
        try{
            return new ResponseEntity<>(employeeService.putEmployee(id, employeeInputDTO), HttpStatus.OK) ;
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND) ;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeRoute(@PathVariable int id) throws RuntimeException{
        try{
            return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK) ;
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND) ;
        }
    }
}
