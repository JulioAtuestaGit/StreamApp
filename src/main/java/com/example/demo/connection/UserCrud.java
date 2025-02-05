package com.example.demo.connection;
import com.example.demo.data.ITableCrud;
import com.example.demo.model.UserTableMap;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*this runs the CRUD tasks - representen in the interface ItableCrud- for objects type user - mapping the users table -
* thus we have a calss user to mapp the table, an interface to declare CRUD methods and a class to define those methods
* applying them to the users , and future classes to apply same methods to productions */
public class UserCrud implements ITableCrud {

    @Override
    public List<UserTableMap> listItem() {
        List<UserTableMap> usersList= new ArrayList();
        // here sql statements to retrieve all users in the table showing.. what?
        return usersList;
    }

    @Override
    public Object findId(int id) {
        return null;
    }

    @Override
    public boolean addItem(Object item) {
        return false;
    }

    @Override
    public boolean modifyItem(Object item) {
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        return false;
    }
}
