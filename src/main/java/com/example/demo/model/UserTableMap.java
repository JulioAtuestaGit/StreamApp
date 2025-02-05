package com.example.demo.model;
import jakarta.persistence.*;
/*Mapping database Users table */
@Entity
@Table(name = "users")
public class UserTableMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    public UserTableMap(String userName, String userPassword, String userNickname) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
    }

    public Long getId() { return id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
}
