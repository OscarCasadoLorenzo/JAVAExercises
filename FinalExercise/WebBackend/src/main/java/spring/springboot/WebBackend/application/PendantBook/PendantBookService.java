package spring.springboot.WebBackend.application.PendantBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.domain.PendantBookEntity;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.PendantBookOutputDTO;
import spring.springboot.WebBackend.infraestructure.repository.PendantBookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PendantBookService implements PendantBookInterface{

    @Autowired
    PendantBookRepository pendantBookRepository;

    @Override
    public List<PendantBookOutputDTO> getAllPendantBooks() {
        List<PendantBookOutputDTO> pendantBookOutputDTOList = new ArrayList<>();
        for(PendantBookEntity pendantBookEntity : pendantBookRepository.findAll()){
            pendantBookOutputDTOList.add(new PendantBookOutputDTO(pendantBookEntity));
        }
        return pendantBookOutputDTOList;
    }

    @Override
    public List<PendantBookOutputDTO> getPendantBooksByCustomerService(String consumerServiceID) {
        List<PendantBookOutputDTO> pendantBookOutputDTOList = new ArrayList<>();
        for(PendantBookEntity pendantBookEntity : pendantBookRepository.findByService(consumerServiceID)){
            pendantBookOutputDTOList.add(new PendantBookOutputDTO(pendantBookEntity));
        }
        return pendantBookOutputDTOList;
    }

    @Override
    public List<PendantBookOutputDTO> getPendantBooksByState(String state) {
        List<PendantBookOutputDTO> pendantBookOutputDTOList = new ArrayList<>();
        for(PendantBookEntity pendantBookEntity : pendantBookRepository.findByRequeststate(state)){
            pendantBookOutputDTOList.add(new PendantBookOutputDTO(pendantBookEntity));
        }
        return pendantBookOutputDTOList;
    }
}
