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
	public CommandLineRunner setupData(BoxRepository repo) {
		return (args) -> {
			repo.save(new Box(null, "HeartBox", "MyAuthor", null));
			repo.save(new Box(null, "RoundedBox", "AnotherAuthor",null));
			repo.save(new Box(null, "NormalBox", "Author", null));
			repo.save(new Box(null, "SquaredBox", "YetAnotherAuthor",null));
			repo.save(new Box(null, "HexagonalBox", "YourAuthor", null));
			repo.save(new Box(null, "PureBox", "ArthurKingOfBritons",null));
		};
	}
}
