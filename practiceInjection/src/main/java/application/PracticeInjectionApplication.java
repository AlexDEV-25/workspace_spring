package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "vn.base.rest", "vn.base.service" })
public class PracticeInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeInjectionApplication.class, args);
	}

}
