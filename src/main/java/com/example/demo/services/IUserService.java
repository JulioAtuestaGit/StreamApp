package com.example.demo.services;

import com.example.demo.model.Users;
import java.util.List;
/*could be added to Users or UserService class, yet it would only work for one table
* as an interface this can be implemented by all mapping classes for each table
* */
public interface  IUserService {
    public List<Users> usersList();
    public Users getUserById(Integer id); //received an empty user mapped an existing user in the table
    public void savedUser(Users user);
    public void deleteUSer(Users user);
    public boolean isUserEmailRegistered(String userEmail);
}
