package com.onito.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class OnitoTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnitoTaskApplication.class, args);
	}

}
