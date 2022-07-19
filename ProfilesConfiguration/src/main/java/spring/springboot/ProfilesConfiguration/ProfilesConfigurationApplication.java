package spring.springboot.ProfilesConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ProfilesConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilesConfigurationApplication.class, args);
	}

}
