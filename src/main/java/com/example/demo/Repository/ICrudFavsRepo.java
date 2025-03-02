package com.example.demo.Repository;
import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserFavs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICrudFavsRepo extends CrudRepository<UserFavs, Integer>{
    @Query("SELECT uf FROM UserFavs uf WHERE uf.userId = :userId AND uf.productionId = :productionId ")
    UserFavs isSaved (@Param("userId") Integer userId, @Param("productionId") Integer productionId);
    List<ShortProduction> findByUserId(Integer userID);
    }
