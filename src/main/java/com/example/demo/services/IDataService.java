package com.example.demo.services;
import java.util.List;
/*could be added to Users or UserService class, yet it would only work for one table
* as an interface this can be implemented by all mapping classes for each table
* */
public interface IDataService <T>{
    public List<T> dataList();
    public T getRowById(Integer id); //received an empty user mapped an existing user in the table
    public void saveData(T data);
    public void deleteData(T data);
}