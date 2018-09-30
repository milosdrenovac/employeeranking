package com.univer.berka.employeeranking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class EmployeeRankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRankingApplication.class, args);
	}
}
