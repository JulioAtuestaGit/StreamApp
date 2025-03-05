package com.example.demo.services;

import com.example.demo.model.ShortProduction;
import com.example.demo.services.Interfaces.IFavsService;
import com.example.demo.services.Interfaces.IHistoryService;
import com.example.demo.services.RepoService.ShortProductionServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavsServiceLogic {

    @Autowired
    private IFavsService favsService;

    @Autowired
    private ShortProductionServiceRepo shortProductionServiceRepo;

    public List<ShortProduction> displayFavs(Integer userId){
        return  favsService.findProductionsByUserId(userId);
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

    public void removeHistory(Integer userId){
    }


}
