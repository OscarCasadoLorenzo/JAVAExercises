package spring.springboot.DependencyInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionApplication.class, args);
	}

	@Bean
	@Qualifier("standardBean")
	public PersonService getPerson() {
		PersonService personService = new PersonImplementation();
		return personService;
	}

	@Bean
	@Qualifier("bean1")
	public PersonService getPersonBean1() {
		PersonService personService = new PersonImplementation();
		personService.setName("bean1");
		return personService;
	}

	@Bean
	@Qualifier("bean2")
	public PersonService getPersonBean2() {
		PersonService personService = new PersonImplementation();
		personService.setName("bean2");
		return personService;
	}

	@Bean
	@Qualifier("bean3")
	public PersonService getPersonBean3() {
		PersonService personService = new PersonImplementation();
		personService.setName("bean3");
		return personService;
	}

}
