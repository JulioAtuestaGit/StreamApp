package com.example.demo;

import com.example.demo.connection.DataBaseConnection;
import com.example.demo.data.UserCrud;
import com.example.demo.services.MappingProductions;
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
			//var testingConection = dataBaseConnection.dbConection();
		    //System.out.println(testingConection);
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


/*
* Db profiles
* history
* favs
* most viewedsolo el deposito
*/
