/* adds productions to table production if those are not yet
* add production to history
* add production to favorites
* */
package com.example.demo.services;
import com.example.demo.Repository.ICrudFavsRepo;
import com.example.demo.Repository.ICrudHistoryRepo;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private IHistoryService historyService;

    private ShortProduction productionToBeAdded;
    private UserHistory userHistory;
    private UserFavs userFavs;

    Scanner scanner = new Scanner(System.in);

    public void chooseTitle(MultipleProductions filteredProd){
        System.out.println("Type title number :\n");
        int selection = scanner.nextInt();
        filteredProd.getShortProductions().get(selection-1).play();
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
            addToFavs(userId, selectedProd.getId());
        }
        selectedProd.play();
    }

    public  void isSaved(ShortProduction selectedProd, Integer userId){
        //PAso 1 verificar que la query jqpl si retorne algo, para eso retornamos el la fila completa
        /*verificar si la prodcution esta en la tabla, si no añadirla*/
        selectedProd = shortProductionService.isSaved(selectedProd.getTitle(),selectedProd.getType());
        System.out.println(selectedProd);

        if (selectedProd != null) {
            System.out.println("Production found: " + selectedProd.getTitle());
            System.out.println(":::::::::::::::pod ID "  + selectedProd.getId());
            addToHistory(userId,selectedProd.getId());
        } else {
            System.out.println("Production NOT found.");
            shortProductionService.saveData(selectedProd);
            System.out.println("Production Saved");
            addToHistory(userId,selectedProd.getId());
        }

        /*mo strar detalles de produccion añadiendo a la tabla mas grande*/
    }

    public void addToFavs(Integer userId, Integer productionId){
        // verificar si existe ya en los favs o no*/
    //añadirlo //
        if(favsService.isSaved(userId,productionId) != null){
            System.out.println(":::::::"+userId +" : "+productionId);
            favsService.deleteProd(userId,productionId);
            System.out.println("Removed form favs");
        }else {
            System.out.println(":::::::"+userId +" : "+productionId);
            favsService.saveProd(userId,productionId);
            System.out.println("Added to FAvs");
        }
    }

    public void addToHistory(Integer userId, Integer productionId){
        // verificar si ya existe o no en la tabla de historial*/
        //añadir la production al history poruqe ya se empezo a ver
        if(historyService.isSaved(userId,productionId) != null){
            System.out.println("Already in history");
        }else {
            historyService.saveProd(userId,productionId);
            System.out.println("Added to History");
        }
    }
}
