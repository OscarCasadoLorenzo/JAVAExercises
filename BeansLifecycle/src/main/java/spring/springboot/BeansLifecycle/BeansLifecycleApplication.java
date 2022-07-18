package spring.springboot.BeansLifecycle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeansLifecycleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BeansLifecycleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("I am the third class, the application arguments are: " + args[0] + " " + args[1]);
	}
}
