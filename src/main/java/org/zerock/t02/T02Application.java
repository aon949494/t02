package org.zerock.t02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class T02Application {

	public static void main(String[] args) {
		SpringApplication.run(T02Application.class, args);
	}

}
