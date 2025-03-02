package com.example.demo.services.Interfaces;
import com.example.demo.model.UserFavs;
import org.springframework.data.repository.query.Param;

public interface IFavsService {
    UserFavs isSaved (@Param("userId") Integer userId, @Param("productionId") Integer productionId);
    void saveProd (Integer userId, Integer productionId);
    void deleteProd (Integer userId, Integer productionId);

}
