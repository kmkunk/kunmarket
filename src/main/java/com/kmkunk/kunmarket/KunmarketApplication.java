package com.kmkunk.kunmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KunmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KunmarketApplication.class, args);
	}

}
