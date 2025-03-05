package com.example.demo;

import com.example.demo.model.MultipleProductions;
import com.example.demo.model.ShortProduction;
import com.example.demo.services.*;
import com.example.demo.services.Interfaces.IHistoryService;
import com.example.demo.services.Interfaces.IUserService;
import com.example.demo.services.ProductionLogic.FilterProduction;
import com.example.demo.services.ProductionLogic.MappingProductions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
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
	@Autowired
	private FavsServiceLogic favsServiceLogic;

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
								if(returnedProds.getTotal().equals("0")){break;}
								returnedProds = filterProduction.filterProductions(returnedProds);
								if(returnedProds.getShortProductions().isEmpty()){break;}
								selection.chooseTitle(returnedProds,userId);
								break;

							case 2://history
								StringBuilder historyList = new StringBuilder();
								List <ShortProduction> returnedHistory = historyServiceLogic.displayHistory(userId);
								for (int i=0; i<returnedHistory.size() ;i++){
									historyList.append(i+1).append("- ").append(returnedHistory.get(i).getTitle()).append("\n");
								}
								System.out.println(historyList);
								selection.chooseTitle(returnedHistory);
								break;

							case 3://favs
								StringBuilder favsList = new StringBuilder();
								List <ShortProduction> returnedFavs = favsServiceLogic.displayFavs(userId);
								System.out.println(returnedFavs);
								for (int i=0; i<returnedFavs.size() ;i++){
									favsList.append(i+1).append("- ").append(returnedFavs.get(i).getTitle()).append("\n");
								}
								System.out.println("main list: "+favsList);
								selection.chooseTitle(returnedFavs);
								break;
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