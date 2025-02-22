/* adds productions to table production if those are not yet
* add production to history
* add production to favorites
* */
package com.example.demo.services;
import com.example.demo.Repository.ICrudFavsRepo;
import com.example.demo.Repository.ICrudHistoryRepo;
import com.example.demo.model.MultipleProductions;
import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserFavs;
import com.example.demo.model.UserHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ProductionSelectionComponent {
    @Autowired
    private IProductionService<ShortProduction> iProductionService;
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
        /*verificar si la prodcution esta en la tabla, si no añadirla*/
        /*mo strar detalles de produccion añadiendo a la tabla mas grande*/
    }
    public void addToFavs(){
    /*mostrar opcion de añadir a los favs // añadirlo // verificar si existe ya en los favs o no*/
    }
    public void addToHistory(){
        /*añadir la production al history poruqe ya se empezo a ver // verificar si ya existe o no */
    }
}
