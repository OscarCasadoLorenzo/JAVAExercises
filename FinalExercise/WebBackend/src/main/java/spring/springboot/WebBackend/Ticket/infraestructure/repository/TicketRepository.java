package spring.springboot.WebBackend.Ticket.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.WebBackend.Ticket.domain.TicketEntity;

import java.util.UUID;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
}
