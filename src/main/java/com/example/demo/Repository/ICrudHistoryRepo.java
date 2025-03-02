package com.example.demo.Repository;
import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICrudHistoryRepo extends CrudRepository<UserHistory,Integer> {
    @Query("SELECT hs FROM UserHistory hs WHERE hs.userId = :userId AND hs.productionId = :productionId ")
    UserHistory isSaved (@Param("userId") Integer userId, @Param("productionId") Integer productionId);
    List<ShortProduction> findByUserId(Integer userId);
}
