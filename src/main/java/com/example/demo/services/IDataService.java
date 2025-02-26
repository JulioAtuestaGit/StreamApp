package com.example.demo.services;
import java.util.List;

/*could be added to Users or UserService class, yet it would only work for one table
* as an interface this can be implemented by all mapping classes for each table
* */
public interface IDataService <T>{
    public List<T> dataList();// generics, applicable to users ?//yes as its override with the proper type and name in service body
    public T getRowById(Integer id); //received an empty user mapped an existing user in the table
    public void saveData(T data);
    public void deleteData(T data);
}