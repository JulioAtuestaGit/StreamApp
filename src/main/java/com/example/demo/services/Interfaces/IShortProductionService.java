package com.example.demo.services.Interfaces;
import com.example.demo.model.ShortProduction;
import org.springframework.data.repository.query.Param;

public interface IShortProductionService extends IDataService<ShortProduction> {

    ShortProduction isSaved(@Param("title") String title,@Param("type") String type/*,@Param("year") String year*/);
    ShortProduction getShortProductionByTitle(String title);
    ShortProduction getShortProductionByType(String type);
    ShortProduction getShortProductionByYear(String year);
}
