package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.app.service.CalculatorService;

@SpringBootApplication
public class SpringAopApplication {

	private final CalculatorService calculatorService;

	SpringAopApplication(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(CalculatorService calculatorService) {
		return runner -> {
			System.out.println(calculatorService.cong(10, 13));
			System.out.println(calculatorService.tru(10, 12));
			System.out.println(calculatorService.nhan(10, 9));
			System.out.println(calculatorService.chia(10, 6));

		};
	}

}
