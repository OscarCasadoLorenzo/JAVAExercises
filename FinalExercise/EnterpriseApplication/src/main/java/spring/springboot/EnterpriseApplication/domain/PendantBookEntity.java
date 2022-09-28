package spring.springboot.EnterpriseApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PENDANT_BOOK")
public class PendantBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticketID")
    private Integer id;

    @Column(name = "requestState")
    private String requestState;

    @Column(name = "consumerServiceID")
    private String consumerServiceID;
}
