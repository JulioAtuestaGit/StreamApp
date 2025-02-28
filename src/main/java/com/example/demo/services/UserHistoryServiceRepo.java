package com.example.demo.services;

import com.example.demo.Repository.ICrudHistoryRepo;
import com.example.demo.model.UserFavs;
import com.example.demo.model.UserHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHistoryServiceRepo implements IHistoryService{

    @Autowired
    ICrudHistoryRepo crudHistoryRepo;

    @Override
    public void saveProd(Integer userId, Integer productionId) {
        UserHistory savingHistory = new UserHistory();
        savingHistory.setUserId(userId);
        savingHistory.setProductionId(productionId);
        crudHistoryRepo.save(savingHistory);
        System.out.println("saving");
    }

    @Override
    public UserHistory isSaved(Integer userId, Integer productionId) {
        return crudHistoryRepo.isSaved(userId,productionId);
    }
    @Override
    public void deleteProd(Integer userId, Integer productionId) {
        UserHistory removeHistory = new UserHistory();
        removeHistory.setUserId(userId);
        removeHistory.setProductionId(productionId);
        crudHistoryRepo.delete(removeHistory);
    }
}
