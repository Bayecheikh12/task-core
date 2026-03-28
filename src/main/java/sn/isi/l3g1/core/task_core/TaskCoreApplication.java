package sn.isi.l3g1.core.task_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Point d'entrée de l'application Task Core.
 * Scanne tous les packages du projet pour détecter les composants Spring.
 */
@SpringBootApplication
@ComponentScan(basePackages = "sn.isi.l3g1.core")
@EntityScan(basePackages = "sn.isi.l3g1.core.model")
@EnableJpaRepositories(basePackages = "sn.isi.l3g1.core.repository")
public class TaskCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskCoreApplication.class, args);
	}

}
