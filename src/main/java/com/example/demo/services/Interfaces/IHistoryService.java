package com.example.demo.services.Interfaces;
import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserHistory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IHistoryService extends IDataService<UserHistory>{
    UserHistory isSaved (@Param("userId") Integer userId, @Param("productionId") Integer productionId);
    void saveProd (Integer userId, Integer productionId);
    void deleteProd (Integer userId, Integer productionId);
    List<UserHistory> findByUserId(@Param("userId") Integer userId);
}
