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

public class UserFavs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "production_id")
    private Integer productionId;
}
