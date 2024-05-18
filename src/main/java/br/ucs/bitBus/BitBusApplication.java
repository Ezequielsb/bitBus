package br.ucs.bitBus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.ucs.entities")
@SpringBootApplication(scanBasePackages={"br.ucs.controllers", "br.ucs.entities", "br.ucs.services"})
public class BitBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitBusApplication.class, args);
	}

}
