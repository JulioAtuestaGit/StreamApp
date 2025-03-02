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
    @Query(value = "SELECT production_id FROM user_history WHERE user_id = :userId", nativeQuery = true)
    List<Integer> findByUserId(@Param("userId") Integer userId);

}
