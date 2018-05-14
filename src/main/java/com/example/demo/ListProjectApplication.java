package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"entities"})
@EnableJpaRepositories(basePackages={"data"})
@ComponentScan(basePackages={"controllers"})
@EnableAutoConfiguration
public class ListProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListProjectApplication.class, args);
	}
}
