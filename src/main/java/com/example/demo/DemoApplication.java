package com.example.demo;

import com.example.demo.model.Production;
import com.example.demo.services.ApiRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
		private String userRequest;
		private int userSelection;
		Scanner scanner = new Scanner(System.in);
		private ApiRequest apiRequest = new ApiRequest();
		private ObjectMapper mapper = new ObjectMapper();
	@Override
	public void run(String... args) throws JsonProcessingException {

		/*Entrada mover a clase*/
		System.out.println("""
				Selecciona el tipo de busqueda:
				1 - Pelicula
				2 - Serie
				""");
		if (scanner.nextInt() == 1){
			System.out.println("Ingresa el nombre de la Pelicula que deseas buscar :");
			userRequest=scanner.nextLine();
		} else if (scanner.nextInt() == 2) {
			System.out.println("Ingresa el nombre de la Eerie que deseas buscar :");
			userRequest=scanner.nextLine();
		}
		String json = apiRequest.obtenerDatos(userRequest);
		Production jsonMapped = mapper.readValue(json,Production.class);
		System.out.println(jsonMapped.toString());
	}
}
