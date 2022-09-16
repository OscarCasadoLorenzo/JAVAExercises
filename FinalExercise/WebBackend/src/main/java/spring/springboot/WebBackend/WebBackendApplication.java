package spring.springboot.WebBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import spring.springboot.WebBackend.domain.PersonEntity;
import spring.springboot.WebBackend.infraestructure.repository.PersonRepository;
import spring.springboot.WebBackend.domain.TripEntity;
import spring.springboot.WebBackend.infraestructure.repository.TripRepository;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class WebBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebBackendApplication.class, args);
	}
}
