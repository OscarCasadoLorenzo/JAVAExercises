package spring.springboot.EnterpriseApplication.insfraestructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.springboot.EnterpriseApplication.domain.EmailEntity;

@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Integer> {
}
