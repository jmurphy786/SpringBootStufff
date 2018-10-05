package com.qa.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing

public class MySpringBootMiniProjectApplication {	
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootMiniProjectApplication.class, args);
	}
	
}
