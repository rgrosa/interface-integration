package br.com.renan;

import br.com.renan.exception.ConfigurationServerRequestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ConfigurationServerRequestException {
		SpringApplication.run(Application.class, args);
	}
}
