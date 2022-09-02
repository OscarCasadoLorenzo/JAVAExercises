package spring.springboot.WebBackend.Ticket.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springboot.WebBackend.Person.domain.PersonEntity;
import spring.springboot.WebBackend.Person.infraestructure.controller.dto.output.PersonOutputDTO;
import spring.springboot.WebBackend.Person.infraestructure.repository.PersonRepository;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.input.TicketInputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.controller.dto.output.TicketOutputDTO;
import spring.springboot.WebBackend.Ticket.infraestructure.repository.TicketRepository;
import spring.springboot.WebBackend.Trip.domain.TripEntity;
import spring.springboot.WebBackend.Trip.infraestructure.repository.TripRepository;
import spring.springboot.WebBackend.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public TicketOutputDTO getTicketByID(UUID id) {
        return new TicketOutputDTO(ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket with id: " + id + " doesnt exists.")));
    }

    @Override
    public TicketOutputDTO postTicket(TicketInputDTO ticketInputDTO) {
        UUID personID = ticketInputDTO.getPersonID();
        UUID tripID = ticketInputDTO.getTripID();

        PersonEntity personEntity = personRepository.findById(personID)
                .orElseThrow(() -> new NotFoundException("Ticket with id: " + personID + " doesnt exits."));

        TripEntity tripEntity = tripRepository.findById(tripID)
                .orElseThrow(() -> new NotFoundException("Trip with id: " + tripID + " doesnt exists."));

        TicketEntity ticketEntity = new TicketEntity(tripEntity, personEntity);
        ticketRepository.save(ticketEntity);
        return new TicketOutputDTO(ticketEntity);
    }

    @Override
    public TicketOutputDTO updateTicket(UUID id, TicketInputDTO ticketInputDTO) {
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
    public TicketOutputDTO deleteTicket(UUID id) {
        TicketOutputDTO ticketOutputDTO = getTicketByID(id);
        ticketRepository.deleteById(id);
        return ticketOutputDTO;
    }
}
