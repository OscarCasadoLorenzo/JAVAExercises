package spring.springboot.WebBackend.infraestructure.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot.WebBackend.application.PendantBook.PendantBookService;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.PendantBookOutputDTO;

import java.util.List;

@RestController
@RequestMapping("/api/backweb/pendantbook")
public class PendantBookController {

    @Autowired
    PendantBookService pendantBookService;

    @GetMapping
    public List<PendantBookOutputDTO> getAllPendantBooksRoute(){
        return pendantBookService.getAllPendantBooks();
    }

    @GetMapping("/service/{consumerServiceID}")
    public List<PendantBookOutputDTO> getPendantBooksByCustomerServiceRoute(@PathVariable String consumerServiceID){
        return pendantBookService.getPendantBooksByCustomerService(consumerServiceID);
    }

    @GetMapping("/state/{state}")
    public List<PendantBookOutputDTO> getPendantBooksByStateRoute(@PathVariable String state){
        return pendantBookService.getPendantBooksByState(state);
    }

}
