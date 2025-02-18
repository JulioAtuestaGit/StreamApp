package com.example.demo.services;

import com.example.demo.model.Users;
import java.util.List;
/*could be added to Users or UserService class, yet it would only work for one table
* as an interface this can be implemented by all mapping classes for each table
* */
public interface IDataService {
    public List<Users> usersList();
    public Users getRowById(Integer id); //received an empty user mapped an existing user in the table
    public void saveData(Users user);
    public void deleteData(Users user);
    public Users findByUserEmail(String userEmail);
    public Users findByUserNickname(String userNickname);
}
