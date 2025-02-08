package com.example.demo.model;
import jakarta.persistence.*;
/*Mapping database Users table */
@Entity
@Table(name = "users")
public class UserTableMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_nickname")
    private String userNickname;

/* Not yet, this could be arrays or a 'pointer' to other tables that have all the productions
    @Column(name = "User_favs")
    private String userFavs;
    @Column(name = "user_history")
    private String userHistory;
*/

    public UserTableMap() {
    }

    public UserTableMap(String userName, String userPassword, String userNickname) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
    }

    @Override
    public String toString() {
  /*      StringBuilder stringBuilder = new StringBuilder();
        usersList.forEach(user ->{
            stringBuilder.append(user.getId() + " " +user.getUserName() +" "+ user.getUserNickname()+"\n");
        });
        System.out.println(stringBuilder);*/
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getId()+" "+this.getUserName() +" "+this.getUserPassword()+" "+this.getUserNickname()+"\n");
        return stringBuilder.toString();
    }

    public int getId() { return id; }
    public String getUserName() { return userName; }
    public String getUserPassword() { return userPassword; }
    public String getUserNickname() {return userNickname;}

    public void setId(int id) {this.id = id;}
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public void setUserNickname(String userNickname) {this.userNickname = userNickname;}
}
