package com.example.demo.services.RepoService;

import com.example.demo.Repository.ICrudHistoryRepo;
import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserHistory;
import com.example.demo.services.Interfaces.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserHistoryServiceRepo implements IHistoryService {

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

    @Override
    public List<ShortProduction> findByUserId(Integer userId) {
        List<ShortProduction> userHistory= new ArrayList<ShortProduction>();
        crudHistoryRepo.findByUserId(userId);
        return userHistory;
    }

    @Override
    public List<UserHistory> dataList() {
        return List.of();
    }

    @Override
    public UserHistory getRowById(Integer id) {
        return null;
    }

    @Override
    public void saveData(UserHistory data) {

    }

    @Override
    public void deleteData(UserHistory data) {

    }
}
