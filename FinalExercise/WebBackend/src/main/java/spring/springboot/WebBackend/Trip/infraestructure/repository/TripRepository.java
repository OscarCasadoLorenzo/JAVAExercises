package spring.springboot.WebBackend.Trip.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.WebBackend.Trip.domain.TripEntity;

@Repository
public interface TripRepository extends CrudRepository<TripEntity, Integer> {
}
