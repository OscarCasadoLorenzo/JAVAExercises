package spring.springboot.TableRelations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import spring.springboot.TableRelations.Person.proxy.TeacherServiceProxy;

@SpringBootApplication
@EnableFeignClients
public class TableRelationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(TableRelationsApplication.class, args);
	}

}
