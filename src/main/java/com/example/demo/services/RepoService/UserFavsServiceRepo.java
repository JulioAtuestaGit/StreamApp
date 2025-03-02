package com.example.demo.services.RepoService;

import com.example.demo.Repository.ICrudFavsRepo;
import com.example.demo.model.ShortProduction;
import com.example.demo.model.UserFavs;
import com.example.demo.services.Interfaces.IFavsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavsServiceRepo implements IFavsService {
    @Autowired
    ICrudFavsRepo crudFavsRepo;

    @Override
    public UserFavs isSaved(Integer userId, Integer productionId) {
        return crudFavsRepo.isSaved(userId,productionId);
    }

    @Override
    public List<ShortProduction> findByUserId(Integer userID) {
        return crudFavsRepo.findByUserId(userID);  // crear query ?
    }

    @Override
    public void saveProd(Integer userId, Integer productionId) {
        UserFavs newFav = new UserFavs();
        newFav.setUserId(userId);
        newFav.setProductionId(productionId);
        crudFavsRepo.save(newFav);
    }

    @Override
    public void deleteProd(Integer userId, Integer productionId) {
        UserFavs removeFav = isSaved(userId,productionId);
        //this way if that prod is a fav to that user we will get that couple id so repo would be able to delete that couple
        if (removeFav != null){
            crudFavsRepo.delete(removeFav);
        }
    }

}
