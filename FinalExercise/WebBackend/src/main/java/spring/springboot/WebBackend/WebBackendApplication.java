package spring.springboot.WebBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebBackendApplication.class, args);
	}
}
