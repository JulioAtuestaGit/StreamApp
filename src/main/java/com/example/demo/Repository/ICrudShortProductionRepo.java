package com.example.demo.Repository;
import com.example.demo.model.ShortProduction;
import com.example.demo.services.IDataService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrudShortProductionRepo extends IDataService<ShortProduction> {
    @Query("SELECT sp FROM ShortProduction sp WHERE sp.title = :title AND sp.type = :type AND sp.year = :year")
    ShortProduction isSaved(@Param("title") String title, @Param("type") String type, @Param("year") String year);
    ShortProduction getShortProductionByTitle(String title);
    ShortProduction getShortProductionByType(String type);
    ShortProduction getShortProductionByYear(String year);
}
