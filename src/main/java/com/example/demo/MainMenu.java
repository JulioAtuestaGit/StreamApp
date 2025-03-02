package com.example.demo;

import com.example.demo.model.MultipleProductions;
import com.example.demo.services.*;
import com.example.demo.services.Interfaces.IUserService;
import com.example.demo.services.ProductionLogic.FilterProduction;
import com.example.demo.services.ProductionLogic.MappingProductions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class MainMenu implements CommandLineRunner {
	@Autowired
	private IUserService iUserService;
	@Autowired
	private UserSession session;
	@Autowired
	private ProductionSelectionComponent selection;
	@Autowired
	HistoryServiceLogic historyServiceLogic;


	private Scanner scanner = new Scanner(System.in);
	private MultipleProductions returnedProds;
	private FilterProduction filterProduction = new FilterProduction();
	private Integer userId;

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
					userId = session.logIn();
					if (userId != null) {
						System.out.println("""
							Please Select an Option
 							1 - Search a Title
 							2 - Resume Watching
 							3 - View Favs
							""");
						switch (scanner.nextInt()){
							case 1:
								returnedProds = MappingProductions.multipleMapping();
								System.out.println(":::::::::  MAIN LINEA 52  ::::::::::: "+returnedProds );
								if(returnedProds.getTotal().equals("0")){break;}
								returnedProds = filterProduction.filterProductions(returnedProds);
								System.out.println(":::::::::  MAIN LINEA 56  ::::::::::: "+returnedProds );
								if(returnedProds.getShortProductions().isEmpty()){break;}
								selection.chooseTitle(returnedProds,userId);
								break;
							case 2:
								System.out.println("user id ::: main :::"+userId);
								System.out.println(
								historyServiceLogic.displayHistory(userId));


							case 3:
								/* metodo ver favoritos*/
						}
					}
					break;
				case 2:
					if (session.signUp()) { /// CAmbiar retornar el id
						returnedProds = MappingProductions.multipleMapping();
						returnedProds = filterProduction.filterProductions(returnedProds);
						selection.chooseTitle(returnedProds);


					}
					break;
				case 3:

					MappingProductions.multipleMapping();
					break;
				default:

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
/*
* 				Modificar Main menu
* 				Modificar API
**				sign up tiene que retornar el id
*
*
* */