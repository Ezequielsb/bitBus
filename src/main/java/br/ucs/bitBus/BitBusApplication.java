package br.ucs.bitBus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="br.ucs.controllers")
public class BitBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitBusApplication.class, args);
	}

}
