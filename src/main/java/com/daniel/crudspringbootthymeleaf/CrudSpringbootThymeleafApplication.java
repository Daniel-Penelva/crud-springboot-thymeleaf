package com.daniel.crudspringbootthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class CrudSpringbootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootThymeleafApplication.class, args);
	}

}
