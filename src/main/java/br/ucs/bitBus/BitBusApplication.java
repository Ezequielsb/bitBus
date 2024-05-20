package br.ucs.bitBus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "br.ucs.entities")
@EnableJpaRepositories(basePackages = "br.ucs.repositorios")
@SpringBootApplication(scanBasePackages={"br.ucs.controllers", "br.ucs.entities", "br.ucs.services", "br.ucs.repositorios"})
public class BitBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitBusApplication.class, args);
	}

}
