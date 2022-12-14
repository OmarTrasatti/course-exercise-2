package it.cineca.springbootbeginner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.cineca.springbootbeginner.models.Box;
import it.cineca.springbootbeginner.repositories.BoxRepository;

@SpringBootApplication
public class SpringDataMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMvcApplication.class, args);
	} 
	
	@Bean
    public CommandLineRunner init(BoxRepository boxRepo) {
        return (args) -> {
            boxRepo.save(new Box(null, "HeartBox", "MyAuthor", null));
            boxRepo.save(new Box(null, "RoundedBox", "AnotherAuthor", null));
            boxRepo.save(new Box(null, "Harry Potter e la pietra filosofale", "J. K. Rowling", null));
            boxRepo.save(new Box(null, "Harry Potter e la camera dei segreti", "J. K. Rowling", null));
            boxRepo.save(new Box(null, "Harry Potter e il prigioniero di Azkaban", "J. K. Rowling", null));
            boxRepo.save(new Box(null, "Harry Potter e il calice di fuoco", "J. K. Rowling", null));
            boxRepo.save(new Box(null, "Harry Potter e l'Ordine della Fenice", "J. K. Rowling", null));
            boxRepo.save(new Box(null, "Harry Potter e il principe mezzosangue", "J. K. Rowling", null));
            boxRepo.save(new Box(null, "Harry Potter e i Doni della Morte", "J. K. Rowling", null));
        };
    }
}
