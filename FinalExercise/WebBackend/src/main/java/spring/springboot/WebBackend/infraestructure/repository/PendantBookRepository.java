package spring.springboot.WebBackend.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.WebBackend.domain.PendantBookEntity;

@Repository
public interface PendantBookRepository extends CrudRepository<PendantBookEntity, Integer> {
}
