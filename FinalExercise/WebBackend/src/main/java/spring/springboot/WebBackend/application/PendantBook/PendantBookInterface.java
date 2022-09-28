package spring.springboot.WebBackend.application.PendantBook;

import org.springframework.web.bind.annotation.PathVariable;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.PendantBookOutputDTO;

import java.util.List;

public interface PendantBookInterface {
    List<PendantBookOutputDTO> getAllPendantBooks();
    List<PendantBookOutputDTO> getPendantBooksByCustomerService(String consumerServiceID);
    List<PendantBookOutputDTO> getPendantBooksByState(String state);
}
