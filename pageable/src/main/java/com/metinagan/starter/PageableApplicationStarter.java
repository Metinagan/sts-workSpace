package com.metinagan.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@SpringBootApplication
@ComponentScan(basePackages = {"com.metinagan"})
@EntityScan(basePackages = {"com.metinagan"})
@EnableJpaRepositories(basePackages = {"com.metinagan"})
public class PageableApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(PageableApplicationStarter.class, args);
	}

}
