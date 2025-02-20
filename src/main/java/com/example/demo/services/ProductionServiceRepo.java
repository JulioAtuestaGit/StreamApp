package com.example.demo.services;

import com.example.demo.Repository.CrudRepository;
import com.example.demo.Repository.ICrudPtoductionRepo;
import com.example.demo.Repository.ICrudUserRepo;
import com.example.demo.model.ShortProduction;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductionServiceRepo  implements IDataService<ShortProduction>{

    @Autowired
    private ICrudPtoductionRepo crudRepository;

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

    }

    @Override
    public void deleteData(ShortProduction data) {

    }
}
