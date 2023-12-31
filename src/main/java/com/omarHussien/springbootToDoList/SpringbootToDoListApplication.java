package com.omarHussien.springbootToDoList;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SpringbootToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootToDoListApplication.class, args);
	}

}
