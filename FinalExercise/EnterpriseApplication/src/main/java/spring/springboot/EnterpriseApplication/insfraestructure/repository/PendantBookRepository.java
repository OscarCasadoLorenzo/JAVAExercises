package spring.springboot.EnterpriseApplication.insfraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.EnterpriseApplication.domain.PendantBookEntity;

@Repository
public interface PendantBookRepository extends CrudRepository<PendantBookEntity, Integer> {
}
