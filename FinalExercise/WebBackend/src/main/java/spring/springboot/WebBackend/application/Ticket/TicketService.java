package spring.springboot.WebBackend.application.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.domain.PersonEntity;
import spring.springboot.WebBackend.infraestructure.repository.PersonRepository;
import spring.springboot.WebBackend.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.infraestructure.repository.TicketRepository;
import spring.springboot.WebBackend.domain.TripEntity;
import spring.springboot.WebBackend.infraestructure.repository.TripRepository;
import spring.springboot.WebBackend.domain.TicketEntity;
import spring.springboot.WebBackend.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements TicketInterface {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    TripRepository tripRepository;

    @Override
    public List<TicketOutputDTO> getAllTickets() {
        List<TicketOutputDTO> ticketOutputDTOList = new ArrayList<>();
        for(TicketEntity ticketEntity : ticketRepository.findAll()){
            ticketOutputDTOList.add(new TicketOutputDTO(ticketEntity));
        }
        return ticketOutputDTOList;
    }

    @Override
    public TicketOutputDTO getTicketByID(Integer id) {
        return new TicketOutputDTO(ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket with id: " + id + " doesnt exists.")));
    }

    @Override
    public TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO) {
        Integer personID = ticketInputDTO.getPersonID();
        Integer tripID = ticketInputDTO.getTripID();

        PersonEntity personEntity = personRepository.findById(personID)
                .orElseThrow(() -> new NotFoundException("Ticket with id: " + personID + " doesnt exits."));

        TripEntity tripEntity = tripRepository.findById(tripID)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + tripID + " doesnt exists."));

        TicketEntity ticketEntity = new TicketEntity(tripEntity, personEntity);
        ticketRepository.save(ticketEntity);
        return new TicketOutputDTO(ticketEntity);
    }

    @Override
    public TicketOutputDTO updateTicket(Integer id, TicketInputDTO ticketInputDTO) {
        TicketEntity ticketEntity = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket with id " + id + " doesnt exists."));

        TripEntity tripEntity = tripRepository.findById(ticketInputDTO.getTripID())
                .orElseThrow(() -> new NotFoundException("Trip with id " + ticketInputDTO.getTripID() + " doesnt exists."));

        PersonEntity personEntity = personRepository.findById(ticketInputDTO.getPersonID())
                .orElseThrow(() -> new NotFoundException("Person with id " + ticketInputDTO.getPersonID() + " doesnt exists."));

        ticketEntity.updateEntity(tripEntity, personEntity);
        ticketRepository.save(ticketEntity);

        return new TicketOutputDTO(ticketEntity);
    }

    @Override
    public TicketOutputDTO deleteTicket(Integer id) {
        TicketOutputDTO ticketOutputDTO = getTicketByID(id);
        ticketRepository.deleteById(id);
        return ticketOutputDTO;
    }
}
