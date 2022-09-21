package spring.springboot.EnterpriseApplication.insfraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springboot.EnterpriseApplication.application.Email.EmailService;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.EmailOutputDTO;

import java.util.List;

@RestController
@RequestMapping("api/backenterprise/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping
    public List<EmailOutputDTO> getAllEmailsRoute(){
        return emailService.getAllEmails();
    }

    @GetMapping("/{id}")
    public EmailOutputDTO getEmailByID(@PathVariable Integer id){
        return emailService.getEmailByID(id);
    }

    @PostMapping
    public void postEmailRoute(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String text
    ){
        emailService.sendEmail(to, subject, text);
    }
}
