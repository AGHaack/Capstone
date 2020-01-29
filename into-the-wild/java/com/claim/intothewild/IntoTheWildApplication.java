package com.claim.intothewild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.claim")
public class IntoTheWildApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntoTheWildApplication.class, args);
		
	}

}
