package com.example.demo;

import com.example.demo.connection.UsersDataBase;
import com.example.demo.services.Mapping;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
			var testingConection = UsersDataBase.dbConection();
		System.out.println(testingConection);
		try{
			//Mapping.multipleMapping();
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
