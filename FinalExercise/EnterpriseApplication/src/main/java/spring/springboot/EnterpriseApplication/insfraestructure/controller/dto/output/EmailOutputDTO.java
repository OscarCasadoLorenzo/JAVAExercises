package spring.springboot.EnterpriseApplication.insfraestructure.controller.dto.output;

import lombok.Data;
import spring.springboot.EnterpriseApplication.domain.EmailEntity;

@Data
public class EmailOutputDTO {
    private Integer id;

    private String from;

    private String to;

    private String subject;

    private String text;

    public EmailOutputDTO(EmailEntity emailEntity){
        this.id = emailEntity.getId();
        this.from = emailEntity.getFromEmail();
        this.to = emailEntity.getToEmail();
        this.subject = emailEntity.getSubject();
        this.text = emailEntity.getText();
    }
}
