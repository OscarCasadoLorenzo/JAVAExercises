package spring.springboot.Testing.SonarQube;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import spring.springboot.Testing.SonarQube.PersonEntity;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    /*  RETURN A PERSONENTITY OR A PERSONOUTPUTDTO?
        It is a good practise to return the Entity object, because
        if in the future we would change a class's property it won't
        do the automatic conversion.
    */
    Optional<PersonEntity> findByUsuario(String user);

}
