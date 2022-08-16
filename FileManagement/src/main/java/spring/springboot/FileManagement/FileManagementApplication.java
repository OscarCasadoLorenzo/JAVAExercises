package spring.springboot.FileManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileManagementApplication {

	public static String fileRoute = "";

	public static void main(String [] args) {
		if(args.length > 0)
			fileRoute = args[0];

		SpringApplication.run(FileManagementApplication.class, args);
	}

}
