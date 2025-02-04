package com.example.demo.model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")  // Mapea con la tabla 'users' en MySQL
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;  // Java usa camelCase, pero en BD es 'user_name'

    @Column(name = "user_password")
    private String userPassword;  // BD usa 'user_password', pero Java usa camelCase

    @Column(name = "User_favs")
    private String userFavs;  // BD usa 'user_password', pero Java usa camelCase

    @Column(name = "user_history")
    private String userHistory;  // BD usa 'user_password', pero Java usa camelCase



    // Constructores
    public Users() {}

    public Users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
}
