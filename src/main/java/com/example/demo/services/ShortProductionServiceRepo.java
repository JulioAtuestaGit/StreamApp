package com.example.demo.services;

import com.example.demo.Repository.ICrudShortProductionRepo;
import com.example.demo.model.ShortProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("productionServiceRepoShortProduction")
public class ShortProductionServiceRepo implements IShortProductionService{

    @Autowired
    private ICrudShortProductionRepo crudRepository;

    @Override
    public ShortProduction isSaved(String title, String type /*,String year*/) {
        return crudRepository.isSaved(title,type/*,year*/);
    }

    @Override
    public ShortProduction getShortProductionByTitle(String title) {
        return crudRepository.getShortProductionByTitle(title);
    }

    @Override
    public ShortProduction getShortProductionByType(String type) {
        return crudRepository.getShortProductionByType(type);
    }

    @Override
    public ShortProduction getShortProductionByYear(String year) {
        return crudRepository.getShortProductionByYear(year);
    }

    public ShortProductionServiceRepo() {
        super();
    }

    @Override
    public void deleteData(ShortProduction data) {

    }

    @Override
    public void saveData(ShortProduction data) {

    }

    @Override
    public ShortProduction getRowById(Integer id) {
        return null;
    }

    @Override
    public List<ShortProduction> dataList() {
        return List.of();
    }
}
