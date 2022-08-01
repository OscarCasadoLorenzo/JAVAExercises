package spring.springboot.TableRelations.Person.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="simpleFeign", url = "http://localhost:8080/teacher/")
public interface TeacherServiceProxy {
    @GetMapping("{id}")
    ResponseEntity<?> getTeacher(@PathVariable int id);
}
