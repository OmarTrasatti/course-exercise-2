package it.cineca.springbootbeginner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.cineca.springbootbeginner.model.Box;
import it.cineca.springbootbeginner.repository.BoxRepository;

@SpringBootApplication
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
