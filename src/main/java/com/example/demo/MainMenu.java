package com.example.demo;

import com.example.demo.services.IUserService;
import com.example.demo.services.MappingProductions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class MainMenu implements CommandLineRunner {
	@Autowired
	private IUserService iUserService;
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(MainMenu.class);// to create logs in the backlog document

	public static void main(String[] args) {
		SpringApplication.run(MainMenu.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("""
					Welcome to productions please select an option
					1 - Sing In
					2 - Sing Up
					3 - Continue as Guest
					""");
			int mainMenu = scanner.nextInt();
			switch (mainMenu){
				case 1:
					//UserCrud.main();
					break;
				case 2:
					//UserCrud.main();
					break;
				case 3:
					MappingProductions.multipleMapping();
					break;
			}
		}catch (Exception e){
			e.getMessage();
		}
	}
}
