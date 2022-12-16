package it.cineca.springbootbeginner.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import it.cineca.springbootbeginner.model.Box;
import it.cineca.springbootbeginner.repository.BoxRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"it.cineca.springbootbeginner.controller",
				"it.cineca.springbootbeginner.service",
				"it.cineca.springbootbeginner.repository",
				"it.cineca.springbootbeginner.config",
				"it.cineca.springbootbeginner.component"})
@EntityScan(basePackages = {"it.cineca.springbootbeginner.model", 
			 "it.cineca.springbootbeginner.dto"})
@EnableJpaRepositories(basePackages = {"it.cineca.springbootbeginner.repository"})
public class SpringBeginnerDay2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeginnerDay2Application.class, args);
		

	}
	
	@Bean
    public CommandLineRunner init(BoxRepository boxRepo) {
        return (args) -> {
            boxRepo.save(new Box(null, "HeartBox", "Jeinny", null));
            boxRepo.save(new Box(null, "RoundedBox", "Alessandro", null));
            boxRepo.save(new Box(null, "SquareBox", "Eleonora", null));
            boxRepo.save(new Box(null, "TriangleBox", "Antonia", null));
            boxRepo.save(new Box(null, "SecondBox", "Omar", null));
        };
    }
}
