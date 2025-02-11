package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String userEmail;
    private String userNickname;
    private String userPassword;

}
