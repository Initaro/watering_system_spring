package com.example.watering_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WateringSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(WateringSystemApplication.class, args);
	}
}