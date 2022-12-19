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
@ComponentScan({
	"it.cineca.springbootbeginner.controller",
	"it.cineca.springbootbeginner.service",
	"it.cineca.springbootbeginner.dto",
	"it.cineca.springbootbeginner.config",
	"it.cineca.springbootbeginner.component"
	})
@EnableJpaRepositories("it.cineca.springbootbeginner.repository")
@EntityScan("it.cineca.springbootbeginner.model")
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
			repo.save(new Box(null, "PureBox", "ArthurKingOfBritonss",null));
		};
	}
}
