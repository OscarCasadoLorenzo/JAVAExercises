package spring.springboot.WebBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.springboot.WebBackend.Person.domain.PersonEntity;
import spring.springboot.WebBackend.Person.infraestructure.repository.PersonRepository;
import spring.springboot.WebBackend.Trip.domain.TripEntity;
import spring.springboot.WebBackend.Trip.infraestructure.repository.TripRepository;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class WebBackendApplication {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	TripRepository tripRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebBackendApplication.class, args);
	}

	@PostConstruct
	public void initializeDB(){

		personRepository.save(new PersonEntity("71230484B", "manolo.agonzalez@bosonit.com", "ManoloContrasena", "Manolo", "Arias Gonzalez", "967823512", "ADMIN"));
		personRepository.save(new PersonEntity("09826343K", "daniel.dmiguel@bosonit.com", "DanielContrasena", "Daniel", "Díez Miguel", "689426986", "USER"));
		personRepository.save(new PersonEntity("09643916L", "emar.agonzalez@bosonit.com", "EmarContrasena", "Emar", "Martínez de Pedro", "609812382", "USER"));
		personRepository.save(new PersonEntity("46328702M", "oscar.clorenzo@bosonit.com", "OscarContrasena", "Oscar", "Casado Lorenzo", "967123879", "USER"));
		personRepository.save(new PersonEntity("28735497F", "alberto.asaavedra@bosonit.com", "AlbertoContrasena", "Alberto", "Alonso Saavedra", "763428973", "USER"));

		tripRepository.save(new TripEntity("Barcelona", new Date(2022, 9, 6), 8));
		tripRepository.save(new TripEntity("Valencia", new Date(2022, 9, 6), 12));
		tripRepository.save(new TripEntity("Madrid", new Date(2022, 9, 6), 12));
		tripRepository.save(new TripEntity("Bilbao", new Date(2022, 9, 7), 16));
		tripRepository.save(new TripEntity("Barcelona", new Date(2022, 9, 7), 16));
		tripRepository.save(new TripEntity("Barcelona", new Date(2022, 9, 8), 20));
	}

}
