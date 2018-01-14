package net.frischware.npboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application { //implements CommandLineRunner{

	//@Autowired
	//private ApplicationConfiguration appConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
