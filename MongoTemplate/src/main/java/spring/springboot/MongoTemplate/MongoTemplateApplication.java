package spring.springboot.MongoTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTemplateApplication.class, args);
	}

}
