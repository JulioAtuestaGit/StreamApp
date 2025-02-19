package com.example.demo.services;
import com.example.demo.Repository.CrudRepository;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/*Why do I need this class if we are only calling crud repository methods with no other logic*/
@Service
public class UserServiceRepo implements IDataService {

    @Autowired
    private CrudRepository crudRepository; // Spring create an 'instance' of the type sent to the  interfaces

    @Override
    public List<Users> usersList() {
        return crudRepository.findAll();
    }

    @Override
    public Users getRowById(Integer id) {
        return crudRepository.findById(id).orElse(null);// find by id returns an optional value
    }

    @Override
    public void saveData(Users user) {
        crudRepository.save(user);
    }

    @Override
    public void deleteData(Users user) {
        crudRepository.delete(user);
    }

    @Override
    public Users findByUserEmail(String userEmail) {
        return crudRepository.findByUserEmail(userEmail);
    }

    @Override
    public Users findByUserNickname(String userNickname) {
        return crudRepository.findByUserNickname(userNickname);
    }
}
