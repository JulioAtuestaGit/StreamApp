package com.example.demo.connection;
import com.example.demo.data.ITableCrud;
import com.example.demo.model.UserTableMap;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.connection.dataBaseConnection.dbConection;

/*this runs the CRUD tasks - representen in the interface ItableCrud- for objects type user - mapping the users table -
* thus we have a calss user to mapp the table, an interface to declare CRUD methods and a class to define those methods
* applying them to the users , and future classes to apply same methods to productions */
public class UserCrud implements ITableCrud<UserTableMap> {

    @Override
    public List<UserTableMap> listItem() {
        List<UserTableMap> usersList= new ArrayList();
        // here sql statements to retrieve all users in the table showing.. what?
        PreparedStatement ppst;
        ResultSet rs;
        Connection connection = dbConection(); // same as databaseConecction.dcconection() it returns and obj type 'connection'
        String sqlQuery = "select * from users order by id";
        try{
            ppst = connection.prepareStatement(sqlQuery);
            rs = ppst.executeQuery();
            while (rs.next()){
                UserTableMap user = new UserTableMap();
                user.setId(rs.getInt("id"));
                user.setUserName (rs.getString("user_name"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserNickname(rs.getString("user_nickname"));
                usersList.add(user);
            }
        }
        catch (Exception e){
            System.out.println("error "+e.getMessage());
        }finally {// se ejecuta siempre incluso si estuviera despues del return
            try {
                connection.close();
            }catch (Exception e){
                System.out.println("Error closing connection" + e.getMessage());
            }
        }
        return usersList;
    }

    @Override
    public UserTableMap findId(int id) {
        UserTableMap returnedObj = new UserTableMap();
        PreparedStatement ppst;
        ResultSet rs;
        Connection connection = dbConection();
        String sqlQuery = "select * from users where id =?"; //? sintaxis query
        try{
            ppst = connection.prepareStatement(sqlQuery);
            ppst.setInt(1, id);
            rs = ppst.executeQuery();
            if(rs.next()){
                returnedObj.setId(id);
                returnedObj.setUserName(rs.getString("user_name"));
                returnedObj.setUserNickname(rs.getString("user_nickname"));
                returnedObj.setUserPassword(rs.getString("user_password"));
            }
        }catch (Exception e){
            System.out.println("Error metodo FindID en UserCrud "+e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                System.out.println("Error closing connection" + e.getMessage());
            }
        }

        return returnedObj;
    }

    @Override
    public boolean addItem(UserTableMap item) {
        return true;
    }

    @Override
    public boolean modifyItem(UserTableMap item) {
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        return false;
    }
    public void main(){
        System.out.println(listItem());
        System.out.println(findId(3));
    }
}
