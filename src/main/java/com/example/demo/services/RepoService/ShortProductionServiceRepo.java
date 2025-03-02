package com.example.demo.services.RepoService;

import com.example.demo.Repository.ICrudShortProductionRepo;
import com.example.demo.model.ShortProduction;
import com.example.demo.services.Interfaces.IShortProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("productionServiceRepoShortProduction")
public class ShortProductionServiceRepo implements IShortProductionService {

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

    @Override
    public void deleteData(ShortProduction data) {
        crudRepository.delete(data);
    }

    @Override
    public void saveData(ShortProduction data) {
        crudRepository.save(data);
    }

    @Override
    public ShortProduction getRowById(Integer id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShortProduction> dataList() {
        return  crudRepository.findAll();
    }
}
