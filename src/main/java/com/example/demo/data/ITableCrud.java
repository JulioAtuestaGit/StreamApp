package com.example.demo.data;
import java.util.List;
    //methods resembling crud

public interface ITableCrud<T> {//generics as it should work for users and productions
    List<?> listItem();
    T findId(int id ); //returns the object
    boolean addItem(T item);
    boolean modifyItem(T item);
    boolean deleteItem(int id);
}
