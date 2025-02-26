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
    private ICrudFavsRepo iCrudFavsRepo;
    @Autowired
    private ICrudHistoryRepo iCrudHistoryRepo;

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
        selectedProd = filteredProd.getShortProductions().get(selection-1);//va al final
        isSaved(selectedProd,userId); // revisa si existe en la tabla de production si esta la añade a historial si no no la guarda y la añade a historual
        System.out.println("user id "+ userId);
        // preguntar si añadir a favs
        System.out.println("Would you like to add :"+selectedProd.getTitle() +" to favorites ? : \n1- Yes \n2-No" );
        selection =scanner.nextInt();
        if (selection == 1){
            addToFavs();
        }
        selectedProd.play();
    }

    public  void isSaved(ShortProduction selectedProd, Integer userId){
        //PAso 1 verificar que la query jqpl si retorne algo, para eso retornamos el la fila completa
        /*verificar si la prodcution esta en la tabla, si no añadirla*/
        ShortProduction result = shortProductionService.isSaved(selectedProd.getTitle(),selectedProd.getType());
        System.out.println(result);

        if (result != null) {
            System.out.println("Production found: " + result.getTitle());
            addToHistory();
        } else {
            System.out.println("Production NOT found.");
            shortProductionService.saveData(selectedProd);
            System.out.println("Production Saved");
            addToHistory();
        }
        System.out.println("Seconf :::::::::");

        /*mo strar detalles de produccion añadiendo a la tabla mas grande*/
    }

    public void addToFavs(){
        // verificar si existe ya en los favs o no*/
    //añadirlo //
        System.out.println("Added to favs");
    }

    public void addToHistory(){
        // verificar si ya existe o no en la tabla de historial*/
        //añadir la production al history poruqe ya se empezo a ver
        System.out.println("Added to History");
    }
}
