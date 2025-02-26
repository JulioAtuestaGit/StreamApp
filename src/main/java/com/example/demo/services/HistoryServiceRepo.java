package com.example.demo.services;

import com.example.demo.Repository.ICrudHistoryRepo;
import com.example.demo.model.UserHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceRepo implements IDataService<UserHistory>{

    @Autowired
    ICrudHistoryRepo iCrudHistoryRepo;

    @Override
    public List<UserHistory> dataList() {
        return iCrudHistoryRepo.findAll();
    }

    @Override
    public UserHistory getRowById(Integer id) {
        return iCrudHistoryRepo.findById(id).orElse(null);
    }

    @Override
    public void saveData(UserHistory data) {
        iCrudHistoryRepo.save(data);
    }

    @Override
    public void deleteData(UserHistory data) {
        iCrudHistoryRepo.delete(data);
    }
}
