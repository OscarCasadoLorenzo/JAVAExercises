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

    @Column(name = "from")
    private String from;

    @Column(name = "to")
    private String to;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;
}
