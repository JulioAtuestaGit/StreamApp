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

/*    public List<ShortProduction> displayHistory(Integer userId) {
        List<ShortProduction> resumeWatching = new ArrayList<ShortProduction>();
        List<Integer> historyProdId = historyService.findByUserId(userId);
        for (Integer id : historyProdId) {
            resumeWatching.add(shortProductionServiceRepo.getRowById(id));
       }
        return resumeWatching;
        findHisByUserId
    }*/

    public List<ShortProduction> displayHistory(Integer userId) {
        return historyService.findHisByUserId(userId);
    }

    public void addToHistory(Integer userId, Integer productionId){
        if(historyService.isSaved(userId,productionId) != null){
            System.out.println("Already in history");
        }else {
            historyService.saveProd(userId,productionId);
            System.out.println("Added to History");
        }
    }

    public void removeHistory(Integer userId){}
    public static class FavsServiceLogic { }
}
