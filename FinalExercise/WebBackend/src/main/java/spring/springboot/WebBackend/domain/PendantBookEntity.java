package spring.springboot.WebBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

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

    @Column(name="tripID")
    private Integer tripID;

    @Column(name="personID")
    private Integer personID;

    @Column(name = "requeststate")
    private String requeststate;

    @Column(name = "service")
    private String service;

    public PendantBookEntity(Integer tripID, Integer personID, String service){
        this.tripID = tripID;
        this.personID = personID;
        this.requeststate = "requested";
        this.service = service;
    }
}
