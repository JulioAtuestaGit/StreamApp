package com.example.demo.connection;
import java.sql.Connection;
import java.sql.DriverManager;
/*Links the JAva project with Mysql's stream_app_users database*/
public class DataBaseConnection {
    public static Connection dbConection(){
        Connection connection = null;
        String streamAppUsers = "stream_app_users";
        String url = "jdbc:mysql://localhost:3306/"+streamAppUsers;
        String user = "root";
        String userPassword = "PaPa00==";//la de mi user en mysql
        System.out.println("DB class :");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,userPassword);
            System.out.println("**** *DB CONNECTED* ****");
        }catch (Exception e){
            System.out.println("error conectando con la db "+e.getMessage());
        }
        return connection;
    }
}