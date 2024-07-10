package com.bronyst.spring_reactive;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("SPRING_R2DBC_URL", dotenv.get("SPRING_R2DBC_URL"));
		System.setProperty("SPRING_R2DBC_USERNAME", dotenv.get("SPRING_R2DBC_USERNAME"));
		System.setProperty("SPRING_R2DBC_PASSWORD", dotenv.get("SPRING_R2DBC_PASSWORD"));
		System.setProperty("SPRING_R2DBC_DRIVER_CLASS_NAME", dotenv.get("SPRING_R2DBC_DRIVER_CLASS_NAME"));
		SpringApplication.run(Application.class, args);
	}
}
