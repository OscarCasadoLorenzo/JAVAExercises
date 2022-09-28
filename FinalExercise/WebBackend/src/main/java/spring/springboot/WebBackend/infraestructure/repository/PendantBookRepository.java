package spring.springboot.WebBackend.infraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.WebBackend.domain.PendantBookEntity;

import java.util.List;

@Repository
public interface PendantBookRepository extends CrudRepository<PendantBookEntity, Integer> {
    List<PendantBookEntity> findByService(String service);
    List<PendantBookEntity> findByRequeststate(String state);
}
