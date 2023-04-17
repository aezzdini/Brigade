package com.example.Brigade;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@KeycloakConfiguration
public class BrigadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrigadeApplication.class, args);
	}

}
