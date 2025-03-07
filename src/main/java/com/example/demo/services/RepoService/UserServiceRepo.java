package com.example.demo.services.RepoService;
import com.example.demo.Repository.ICrudUserRepo;
import com.example.demo.model.Users;
import com.example.demo.services.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/*Why do I need this class if we are only calling crud repository methods with no other logic/ it will it is possible to add extra logic to this  one but not to repo interfaces*/
@Service
public class UserServiceRepo implements IUserService {

    @Autowired
    private ICrudUserRepo crudRepository; // Spring create an 'instance' of the type sent to the  interfaces

    @Override
    public List<Users> dataList() {
        return crudRepository.findAll();
    }

    @Override
    public Users getRowById(Integer id) {
        return crudRepository.findById(id).orElse(null);// find by id returns an optional value
    }

    @Override
    public void saveData(Users data) {
        crudRepository.save(data);
    }

    @Override
    public void deleteData(Users data) {
        crudRepository.delete(data);
    }

    @Override
    public Users findByUserEmail(String userEmail) {
        return crudRepository.findByUserEmail(userEmail);
    }

    @Override
    public Users findByUserNickname(String userNickname)
    {
        return crudRepository.findByUserNickname(userNickname);
    }
}
