package com.example.demo.connection;
import com.example.demo.data.ITableCrud;
import com.example.demo.model.UserTableMap;
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
            rs = ppst.executeQuery(); // executeQuery for Select statements // executeUpdate for insert update delete
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
            System.out.println("error retrieving the whole table"+e.getMessage());
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
            System.out.println("Error  finding User by ID "+e.getMessage());
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
        PreparedStatement ppst;
        Connection connection = dbConection();
        String sqlQuery = "insert into stream_app_users.users(user_name,user_password,user_nickname)values(?,?,?)";
        try{
            ppst = connection.prepareStatement(sqlQuery);
            ppst.setString(1, item.getUserName());
            ppst.setString(2, item.getUserPassword());
            ppst.setString(3, item.getUserNickname());
            ppst.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error Inserting USER in table "+e.getMessage());
            return false;
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                System.out.println("Error closing connection" + e.getMessage());
            }
        }
    }

    @Override
    public boolean modifyItem(UserTableMap item) {
        PreparedStatement ppst;
        Connection connection = dbConection();
        String sqlQuery = "insert into stream_app_users.users(user_name,user_password)values('added_in_Java','java_pass','java_nickname')";
        try{
            ppst = connection.prepareStatement(sqlQuery);
            ppst.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error Inserting USER in table "+e.getMessage());
            return false;
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                System.out.println("Error closing connection" + e.getMessage());
            }
        }
        //return false;
    }

    @Override
    public boolean deleteItem(int id) {
        PreparedStatement ppst;
        Connection connection = dbConection();
        String sqlQuery = "delete From stream_app_users.users where id=?";
        try{
            ppst = connection.prepareStatement(sqlQuery);
            ppst.setInt(1,id);
            ppst.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error Deleting USER from table "+e.getMessage());
            return false;
        }finally {
            try {
                connection.close();
            }catch (Exception e){
                System.out.println("Error closing connection" + e.getMessage());
            }
        }
    }
    public void main(){
        UserTableMap uno = new UserTableMap("añadido","contraseña","añadidoMain");
        System.out.println(listItem());
        System.out.println(findId(1));
        System.out.println("añadido: "+addItem(uno));
        System.out.println(findId(8));
        System.out.println("borrado: "+deleteItem(8));
        System.out.println(listItem());
       // System.out.println(modifyItem(uno));
    }
}
