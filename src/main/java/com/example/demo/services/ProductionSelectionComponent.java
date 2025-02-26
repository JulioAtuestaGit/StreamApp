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

    public void chooseTitle(MultipleProductions filteredProd, Integer userId){
        System.out.println(":::::::: Choose Title :::::::\n");
        System.out.println("Type title number :\n");
        int selection = scanner.nextInt();
        filteredProd.getShortProductions().get(selection-1).play();
        System.out.println("user id "+ userId);
    }
    public  void addProduction(){
        //PAso 1 verificar que la query jqpl si retorne algo, para eso retornamos el la fila completa
        /*verificar si la prodcution esta en la tabla, si no añadirla*/
        ShortProduction result = shortProductionService.isSaved("31 minutos","series","2002-2014");
        System.out.println(result);

        if (result != null) {
            System.out.println("Production found: " + result.getTitle());
        } else {
            System.out.println("Production NOT found.");
        }

        /*mo strar detalles de produccion añadiendo a la tabla mas grande*/
    }
    public void addToFavs(){
    /*mostrar opcion de añadir a los favs // añadirlo // verificar si existe ya en los favs o no*/
    }
    public void addToHistory(){
        /*añadir la production al history poruqe ya se empezo a ver // verificar si ya existe o no */
    }
}
