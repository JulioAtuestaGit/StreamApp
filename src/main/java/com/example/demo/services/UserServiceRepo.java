package com.example.demo.services;
import com.example.demo.Repository.CrudRepository;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceRepo implements IUserService{

    @Autowired
    private CrudRepository crudRepository; // Spring create an 'instance' of the type sent to the  interfaces

    @Override
    public List<Users> usersList() {
        List<Users> usersList = crudRepository.findAll();
        return List.of();
    }

    @Override
    public Users getUserById(Integer id) {
        Users returnedUser = crudRepository.findById(id).orElse(null);// find by id returns an optional value
        return returnedUser;
    }

    @Override
    public void savedUser(Users user) {
        crudRepository.save(user);

    }

    @Override
    public void deleteUSer(Users user) {
        crudRepository.delete(user);
    }
}
