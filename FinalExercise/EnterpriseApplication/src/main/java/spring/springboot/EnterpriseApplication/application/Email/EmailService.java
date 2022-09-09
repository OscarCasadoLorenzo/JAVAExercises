package spring.springboot.EnterpriseApplication.application.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.EnterpriseApplication.domain.EmailEntity;
import spring.springboot.EnterpriseApplication.exceptions.NotFoundException;
import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.EmailOutputDTO;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.EmailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements EmailInterface{

    @Autowired
    EmailRepository emailRepository;

    @Override
    public List<EmailOutputDTO> getAllEmails() {
        List<EmailOutputDTO> emailOutputDTOS = new ArrayList<>();
        for(EmailEntity emailEntity : emailRepository.findAll())
            emailOutputDTOS.add(new EmailOutputDTO(emailEntity));
        return  emailOutputDTOS;
    }

    @Override
    public EmailOutputDTO getEmailByID(Integer id) {
        EmailEntity emailEntity = emailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Email with id: " + id + " doesnt exists."));

        return new EmailOutputDTO(emailEntity);
    }


}
