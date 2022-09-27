package spring.springboot.WebBackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PENDANT_BOOK")
public class PendantBookEntity {
    @Id
    @Column(name="ticketID")
    private Integer id;

    @Column(name = "state", columnDefinition = "requested")
    private String state;

    @Column(name = "consumerServiceID")
    private String consumerServiceID;
}
