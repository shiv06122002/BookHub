package com.tka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookHubApplication.class, args);
		System.out.println("App Started...");
	}

}
