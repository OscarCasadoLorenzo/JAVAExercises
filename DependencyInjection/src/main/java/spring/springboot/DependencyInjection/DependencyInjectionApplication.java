package spring.springboot.DependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		List<City> cityList;
		SpringApplication.run(DependencyInjectionApplication.class, args);
	}

}
