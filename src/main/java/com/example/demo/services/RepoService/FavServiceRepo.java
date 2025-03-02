package com.example.demo.services.RepoService;
import com.example.demo.Repository.ICrudFavsRepo;
import com.example.demo.model.UserFavs;
import com.example.demo.services.Interfaces.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavServiceRepo implements IDataService<UserFavs> {

    @Autowired
    ICrudFavsRepo crudFavsRepo;

    @Override
    public List<UserFavs> dataList() {
        return crudFavsRepo.findAll();
    }

    @Override
    public UserFavs getRowById(Integer id) {
        return crudFavsRepo.findById(id).orElse(null);
    }

    @Override
    public void saveData(UserFavs data) {
        crudFavsRepo.save(data);
    }

    @Override
    public void deleteData(UserFavs data) {
        crudFavsRepo.delete(data);
    }
}
