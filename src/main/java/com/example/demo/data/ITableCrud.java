package com.example.demo.data;
import java.util.ArrayList;
import java.util.List;

public interface ITableCrud<T> {//generics as it should work for users and productions
    //methods resembling crud
    List<?> list = new ArrayList<>();
    T findId(int id ); //returns the object
    boolean addItem(T item);
    boolean modifyItem(T item);
    boolean deleteItem(int id);
}
