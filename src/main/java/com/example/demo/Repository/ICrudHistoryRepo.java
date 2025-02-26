package com.example.demo.Repository;
import com.example.demo.model.UserHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrudHistoryRepo extends CrudRepository<UserHistory,Integer> {
    @Query("SELECT hs FROM UserHistory hs WHERE hs.userId = :userId AND hs.productionId = :productionId ")
    UserHistory isSaved (@Param("userId") Integer userId, @Param("productionId") Integer productionId);
    //void saveProd (Integer userId, Integer productionId);
}
