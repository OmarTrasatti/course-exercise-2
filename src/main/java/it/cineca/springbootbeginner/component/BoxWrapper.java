package it.cineca.springbootbeginner.component;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import it.cineca.springbootbeginner.dto.BoxDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class BoxWrapper {

	List<BoxDto> listBox;
	
}
