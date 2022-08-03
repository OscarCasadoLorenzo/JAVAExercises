package spring.springboot.PostgreDocker.Employee.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.PostgreDocker.Employee.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
