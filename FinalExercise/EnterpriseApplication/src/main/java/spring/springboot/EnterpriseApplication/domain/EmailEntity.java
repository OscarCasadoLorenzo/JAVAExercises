package spring.springboot.EnterpriseApplication.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EMAILS")
@Data
public class EmailEntity {
    @Column(name = "emailID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "fromEmail")
    private String fromEmail;

    @Column(name = "toEmail")
    private String toEmail;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;
}
