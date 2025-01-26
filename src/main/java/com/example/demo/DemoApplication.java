package com.example.demo;

import com.example.demo.services.InputHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		/*Entrada mover a clase*/
		System.out.println("""
				Selecciona search type :
				1 - Pelicula
				2 - Serie
				3 - Episode
				4 - Keywords
				""");
		int userSelection = scanner.nextInt();
		try{
			InputHandler.inputs(userSelection);
		}catch (Exception e){
			e.getMessage();
		}
	}
}
