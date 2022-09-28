package spring.springboot.EnterpriseApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.springboot.EnterpriseApplication.domain.PersonEntity;
import spring.springboot.EnterpriseApplication.domain.TripEntity;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.PersonRepository;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.TripRepository;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class EnterpriseApplication {
	@Autowired
	PersonRepository personRepository;

	@Autowired
	TripRepository tripRepository;

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseApplication.class, args);
	}
}
