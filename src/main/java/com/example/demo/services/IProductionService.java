package com.example.demo.services;

import com.example.demo.model.ShortProduction;

public interface IProductionService<T extends ShortProduction> extends IDataService<T>{
    T getShortProductionByTitle(String title);
    T getShortProductionByType(String type);
    T getShortProductionByYear(String year);
}
