package com.example.demo.services;
import com.example.demo.Repository.CrudRepository;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/*Why do I need this class if we are only calling crud repository methods with no other logic*/
@Service
public class UserServiceRepo implements IUserService{

    @Autowired
    private CrudRepository crudRepository; // Spring create an 'instance' of the type sent to the  interfaces

    @Override
    public List<Users> usersList() {
        return crudRepository.findAll();
    }

    @Override
    public Users getUserById(Integer id) {
        return crudRepository.findById(id).orElse(null);// find by id returns an optional value
    }

    @Override
    public void savedUser(Users user) {
        crudRepository.save(user);
    }

    @Override
    public void deleteUSer(Users user) {
        crudRepository.delete(user);
    }

    @Override
    public boolean isUserEmailRegistered(String userEmail) {
        return crudRepository.findByUserEmail(userEmail)!=null; //true if exists false if no
    }
}
