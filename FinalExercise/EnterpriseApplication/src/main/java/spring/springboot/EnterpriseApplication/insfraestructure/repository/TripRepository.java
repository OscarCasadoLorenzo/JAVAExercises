package spring.springboot.EnterpriseApplication.insfraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.EnterpriseApplication.domain.TripEntity;

@Repository
public interface TripRepository extends CrudRepository<TripEntity, Integer> {
}
