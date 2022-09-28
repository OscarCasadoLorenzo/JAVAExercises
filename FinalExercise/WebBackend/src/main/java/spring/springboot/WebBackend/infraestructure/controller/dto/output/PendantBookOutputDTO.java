package spring.springboot.WebBackend.infraestructure.controller.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import spring.springboot.WebBackend.domain.PendantBookEntity;
import spring.springboot.WebBackend.domain.PersonEntity;

@Getter
@Setter
@ToString
public class PendantBookOutputDTO {
    private Integer id;
    private String requeststate;
    private String service;

    public PendantBookOutputDTO(PendantBookEntity pendantBookEntity){
        this.id = pendantBookEntity.getId();
        this.requeststate = pendantBookEntity.getRequeststate();
        this.service = pendantBookEntity.getService();
    }
}
