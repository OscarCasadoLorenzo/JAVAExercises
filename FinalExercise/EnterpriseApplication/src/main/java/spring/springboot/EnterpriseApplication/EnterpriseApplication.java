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

	@PostConstruct
	public void initializeDB(){

		personRepository.save(new PersonEntity("71230484B", "manolo.agonzalez@gmail.com", "ManoloContrasena", "Manolo", "Arias Gonzalez", "967823512", "ADMIN"));
		personRepository.save(new PersonEntity("09826343K", "daniel.dmiguel@gmail.com", "DanielContrasena", "Daniel", "Díez Miguel", "689426986", "USER"));
		personRepository.save(new PersonEntity("09643916L", "emar.agonzalez@gmail.com", "EmarContrasena", "Emar", "Martínez de Pedro", "609812382", "USER"));
		personRepository.save(new PersonEntity("46328702M", "oscar.clorenzo@gmail.com", "OscarContrasena", "Oscar", "Casado Lorenzo", "967123879", "USER"));
		personRepository.save(new PersonEntity("28735497F", "alberto.asaavedra@gmail.com", "AlbertoContrasena", "Alberto", "Alonso Saavedra", "763428973", "USER"));

		tripRepository.save(new TripEntity("Barcelona", new Date(2022, 9, 6), 8));
		tripRepository.save(new TripEntity("Valencia", new Date(2022, 9, 6), 12));
		tripRepository.save(new TripEntity("Madrid", new Date(2022, 9, 6), 12));
		tripRepository.save(new TripEntity("Bilbao", new Date(2022, 9, 7), 16));
		tripRepository.save(new TripEntity("Barcelona", new Date(2022, 9, 7), 16));
		tripRepository.save(new TripEntity("Barcelona", new Date(2022, 9, 8), 20));
	}


}
