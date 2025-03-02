package com.example.demo.services;

import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserHistory;
import com.example.demo.services.Interfaces.IHistoryService;
import com.example.demo.services.RepoService.ShortProductionServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceLogic {

    @Autowired
    private IHistoryService historyService;
    @Autowired
    private ShortProductionServiceRepo shortProductionServiceRepo;

    public List<ShortProduction> displayHistory(Integer userId){
        List <ShortProduction> resumeWatching = new ArrayList<ShortProduction>();
        List <Integer> historyProdId = historyService.findByUserId(userId);
        System.out.println("History prod: "+historyProdId);
        for(Integer id : historyProdId){ // sintaxis pata recorrer todo el array con el integer
            resumeWatching.add(shortProductionServiceRepo.getRowById(id));
            // si existe en el history existe en la tabla Prod no necesita mapeo de API
        }
         return resumeWatching;
        // historyProdId.forEach(resumeWatching.add(id->resumeWatching.add(shortProductionServiceRepo.getRowById(id))));
        // no sirve id se toma como int y no Integer
        // tomar de la tabla de producciones los titulos
        //mapear los titulos con resultado exacto de la APi
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
    public void removeHistory(Integer userId){
    }

    public static class FavsServiceLogic {
    }
}
