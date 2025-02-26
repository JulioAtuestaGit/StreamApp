package com.example.demo.services;
import com.example.demo.model.UserHistory;
import org.springframework.data.repository.query.Param;

public interface IHistoryService{
    UserHistory isSaved (@Param("userId") Integer userId, @Param("productionId") Integer productionId);
    //void saveProd (Integer userId, Integer productionId);
}
