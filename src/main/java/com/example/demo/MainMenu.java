package com.example.demo;

import com.example.demo.services.IDataService;
import com.example.demo.services.MappingProductions;
import com.example.demo.services.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class MainMenu implements CommandLineRunner {
	@Autowired
	private IDataService iUserService;
	Scanner scanner = new Scanner(System.in);
	@Autowired
	UserSession session;

	public static void main(String[] args) {
		SpringApplication.run(MainMenu.class, args);
	}

	@Override
	public void run(String... args) {

		try {
			System.out.println("""
					Welcome to productions please select an option
					1 - Sing In
					2 - Sing Up
					3 - Continue as Guest
					""");
			int mainMenu = scanner.nextInt();
			scanner.nextLine();
			switch (mainMenu) {
				case 1:
					if (session.logIn()) {
						MappingProductions.multipleMapping();
					}
					break;
				case 2:
					if (session.signUp()) {
						MappingProductions.multipleMapping();
					}
					break;
				case 3:

					MappingProductions.multipleMapping();
					break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
