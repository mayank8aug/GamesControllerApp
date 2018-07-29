package com.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.games")
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.games.repo")
@EntityScan("com.games.model")
public class GameControllerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GameControllerApplication.class, args);
		
	}
	
}
