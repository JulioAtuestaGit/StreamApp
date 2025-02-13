package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
//getters setters tostring and constructor implicitly added on basis form

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private Integer id;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_nickname")
    private String userNickname;
    @Column(name = "user_password")
    private String userPassword;

}
