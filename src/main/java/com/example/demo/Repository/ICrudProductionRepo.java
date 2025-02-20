package com.example.demo.Repository;

import com.example.demo.model.ShortProduction;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrudProductionRepo<T extends ShortProduction> extends CrudRepository<T,Integer>{
    T getShortProductionByTitle(String title);
    T getShortProductionByType(String type);
    T getShortProductionByYear(String year);
}
