package com.example.demo;

import com.example.demo.services.ApiRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args){
		System.out.println("\n\n este es el main de la mierda de spring");
		ApiRequest apiRequest = new ApiRequest();
		String json = apiRequest.obtenerDatos("Inception");
		System.out.println(json);
	}
}
