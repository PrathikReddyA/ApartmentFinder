package com.finalProject.ApartmentFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.finalProject.controller","com.finalProject.dao"})
public class ApartmentFinderApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApartmentFinderApplication.class, args);
	}

}
