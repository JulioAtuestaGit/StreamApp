package com.example.demo.services;

import com.example.demo.model.Users;
import java.util.List;
/*could be added to Users or UserService class, yet it would only work for one table
* as an interface this can be implemented by all mapping classes for each table
* */
public interface IDataService<T> {
    public List<Users> usersList();
    public T getRowById(Integer id); //received an empty user mapped an existing user in the table
    public T saveData(Users user);
    public T deleteData(Users user);
    public Users findByUserEmail(String userEmail);
    public Users findByUserNickname(String userNickname);
}
