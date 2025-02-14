package com.example.demo;

import com.example.demo.model.Users;
import com.example.demo.services.IUserService;
import com.example.demo.services.MappingProductions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class MainMenu implements CommandLineRunner {
	@Autowired
	private IUserService iUserService;
	Scanner scanner = new Scanner(System.in);
	String inputEmail;
	String inputPassword;
	String inputNickname;

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
					if (logIn()) {
						MappingProductions.multipleMapping();
					} else {
						System.out.println("wrong User email or password");
					}
					break;
				case 2:
					signUp();
					break;
				case 3:
					MappingProductions.multipleMapping();
					break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void signUp() {
		System.out.println("""
				***Sign Up***
				Enter your Email:
				""");
		inputEmail = scanner.nextLine();
		Users newUser=new Users();
		if(iUserService.findByUserEmail(inputEmail) != null){
			System.out.println("There is a registered account with that email");
		}else {
			System.out.println("create Password : ");
			inputPassword = scanner.nextLine();
			System.out.println("create user nickname :");
			inputNickname = scanner.nextLine();

			newUser.setUserEmail(inputEmail);
			newUser.setUserPassword(inputPassword);
			newUser.setUserNickname(inputNickname);

			iUserService.savedUser(newUser);
		}
	}

	private boolean logIn() {
		System.out.println("""
				***Log in***
				User's Email:
				""");
		inputEmail = scanner.nextLine();
		System.out.println("User's Password: ");
		inputPassword = scanner.nextLine();
		Users user = iUserService.findByUserEmail(inputEmail);
		if(user!=null ){
			System.out.println("Welcome "+ user.getUserNickname());
			return true;
		}else{return false;}
	}
}
