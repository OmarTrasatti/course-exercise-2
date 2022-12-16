package it.cineca.springbootbeginner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.cineca.springbootbeginner.models.Box;
import it.cineca.springbootbeginner.repository.BoxRepository;

@SpringBootApplication
public class Springbootbeginner2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootbeginner2Application.class, args);
	}
	
    @Bean
    public CommandLineRunner init(BoxRepository boxRepo) {
        return (args) -> {
            boxRepo.save(new Box(null, "HeartBox", "MyAuthor", null));
            boxRepo.save(new Box(null, "RoundedBox", "AnotherAuthor", null));
            boxRepo.save(new Box(null, "SquaredBox", "YetAnotherAuthor", null));
            System.out.println("Creazione box completata");             
        };
    }
}
