package spring.springboot.EnterpriseApplication.application.Email;

import spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output.EmailOutputDTO;

import java.util.List;

public interface EmailInterface {

    List<EmailOutputDTO> getAllEmails();

    EmailOutputDTO getEmailByID(Integer id);
}
