/* adds productions to table production if those are not yet
* add production to history
* add production to favorites
* */
package com.example.demo.services;
import com.example.demo.model.*;
import com.example.demo.services.Interfaces.IFavsService;
import com.example.demo.services.Interfaces.IShortProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ProductionSelectionComponent {
    @Autowired
    private IShortProductionService shortProductionService;
/*
    @Autowired
    private IProductionService<Production> productionService;*/

    @Autowired
    private IFavsService favsService;
    @Autowired
    private HistoryServiceLogic historyService;
    @Autowired
    private FavsServiceLogic favsServiceLogic;
    private ShortProduction productionToBeAdded;
    private UserHistory userHistory;
    private UserFavs userFavs;

    Scanner scanner = new Scanner(System.in);

    public void chooseTitle(MultipleProductions filteredProd){
        System.out.println("Type title number :\n");
        int selection = scanner.nextInt();
        filteredProd.getShortProductions().get(selection-1).play();
    }
    public void chooseTitle(List<ShortProduction> filteredProd){
        System.out.println("Type title number :\n");
        int selection = scanner.nextInt();
        filteredProd.get(selection-1).play();
    }

    public void chooseTitle(MultipleProductions filteredProd, Integer userId){
        ShortProduction selectedProd;
        System.out.println(":::::::: Choose Title :::::::\n");
        System.out.println("Type title number :\n");
        int selection = scanner.nextInt();// aca ya elige
        selectedProd = filteredProd.getShortProductions().get(selection-1);

        isSaved(selectedProd,userId); // revisa si existe en la tabla de production si esta la añade a historial si no no la guarda y la añade a historual
        System.out.println("user id "+ userId);
        // preguntar si añadir a favs
        System.out.println("Would you like to add :"+selectedProd.getTitle() +" to favorites ? : \n1- Yes \n2-No" );
        selection =scanner.nextInt();
        if (selection == 1){
            selectedProd = shortProductionService.isSaved(selectedProd.getTitle(),selectedProd.getType());
            //needed as before this selected prod is mmaped from the api yet we dont know if it is in prod table thus we dont know its id
            favsServiceLogic.addToFavs(userId, selectedProd.getId());
        }
        selectedProd.play();
    }

    public  void isSaved(ShortProduction filteredProd, Integer userId){
        //PAso 1 verificar que la query jqpl si retorne algo, para eso retornamos el la fila completa
        /*verificar si la prodcution esta en la tabla, si no añadirla*/
        ShortProduction selectedProd = shortProductionService.isSaved(filteredProd.getTitle(),filteredProd.getType());
        System.out.println(selectedProd);

        if (selectedProd != null) {
            System.out.println("Production found: " + selectedProd.getTitle());
            System.out.println(":::::::::::::::pod ID "  + selectedProd.getId());
            historyService.addToHistory(userId,selectedProd.getId());
        } else {
            System.out.println("Production NOT found.");
            System.out.println(filteredProd);
            shortProductionService.saveData(filteredProd); //Entity must not be null error
            System.out.println("Production Saved");
            selectedProd = shortProductionService.isSaved(filteredProd.getTitle(),filteredProd.getType());//para tomar el ID recien generado
            historyService.addToHistory(userId,selectedProd.getId());
        }

        /*mo strar detalles de produccion añadiendo a la tabla mas grande*/
    }
}
