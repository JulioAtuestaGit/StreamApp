package com.example.demo.services;

import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserHistory;
import com.example.demo.services.Interfaces.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceLogic {

    @Autowired
    private IHistoryService historyService;

    public List <UserHistory> displayHistory(Integer userId){
        return historyService.findByUserId(userId);
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
