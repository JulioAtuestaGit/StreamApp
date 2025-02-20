package com.example.demo.services;

import com.example.demo.Repository.ICrudProductionRepo;
import com.example.demo.model.ShortProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductionServiceRepo  implements IProductionService<ShortProduction> {

    @Autowired
    private ICrudProductionRepo<ShortProduction> crudRepository;

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

    @Override
    public List<ShortProduction> dataList() {
        return crudRepository.findAll();
    }

    @Override
    public ShortProduction getRowById(Integer id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public void saveData(ShortProduction data) {
        crudRepository.save(data);
    }

    @Override
    public void deleteData(ShortProduction data) {
        crudRepository.delete(data);
    }
}
