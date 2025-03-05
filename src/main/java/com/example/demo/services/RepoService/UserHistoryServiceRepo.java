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
    public List<Integer> findByUserId(Integer userId) {
        return crudHistoryRepo.findByUserId(userId);
    }

    @Override
    public List<ShortProduction> findHisByUserId(Integer userId) {
        return crudHistoryRepo.findHisByUserId(userId);
    }

    @Override
    public List<UserHistory> dataList() {
        return crudHistoryRepo.findAll();
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
