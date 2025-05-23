package com.metinagan.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.metinagan"})
@EnableJpaRepositories(basePackages = {"com.metinagan"})
@ComponentScan(basePackages = {"com.metinagan"})
@SpringBootApplication
public class ExeptionManagementStarter {

	public static void main(String[] args) {
		SpringApplication.run(ExeptionManagementStarter.class, args);
	}

}
