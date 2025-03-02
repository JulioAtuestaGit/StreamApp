/*
package com.example.demo.services;

import com.example.demo.Repository.ICrudShortProductionRepo;
import com.example.demo.model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productionServiceRepoProduction")
public class ProductionServiceRepo implements IShortProductionService {

    @Autowired
    private ICrudShortProductionRepo crudRepository;

    @Override
    public Production isSaved(String title, String type, String year) {
        System.out.println("::::::::: BAD :::::::::");
        return null;
    }

    @Override
    public Production getShortProductionByTitle(String title) {
        return crudRepository.getShortProductionByTitle(title);
    }

    @Override
    public Production getShortProductionByType(String type) {
        return crudRepository.getShortProductionByType(type);
    }

    @Override
    public Production getShortProductionByYear(String year) {
        return crudRepository.getShortProductionByYear(year);
    }

    @Override
    public List<Production> dataList() {
        return crudRepository.findAll();
    }

    @Override
    public Production getRowById(Integer id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public void saveData(Production data) {
        crudRepository.save(data);
    }

    @Override
    public void deleteData(Production data) {
        crudRepository.delete(data);
    }
}
*/
