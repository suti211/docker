package com.bid.emanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class EManagerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EManagerApplication.class, args);
	}
}
