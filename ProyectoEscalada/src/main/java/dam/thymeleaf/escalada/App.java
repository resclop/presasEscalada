package dam.thymeleaf.escalada;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dam.thymeleaf.escalada.model.Presa;
import dam.thymeleaf.escalada.repositories.HoldRepository;

@ComponentScan(basePackages = "dam.thymeleaf.escalada")
@SpringBootApplication 
@EntityScan("dam.thymeleaf.escalada.model")  
@EnableJpaRepositories(basePackages = {"dam.thymeleaf.escalada"})
public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public CommandLineRunner initData(HoldRepository holdRepository) {
		return args -> {
			// Rescatamos todos los productos
			List<Presa> presas =holdRepository.findAll();
			Random r = new Random();
			// Para cada uno de ellos
			for (Presa p : presas) {
				// Vamos a añadirle un número aleatorio de puntuaciones, entre 1 y 10
				for (int i = 0; i < r.nextInt(10); i++) {
					// Lo valoramos con una puntuación aleatoria, entre 3 y 5.
				}
				// Actualizamos los productos, almacenando así su puntuación
				holdRepository.saveAll(presas);
			};
		};
	}
}