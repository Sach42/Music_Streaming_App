package com.sachin.Music.streaming.service.API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer userId;
    private  String userName;

    private  String userEmail;
    private  String userPassword;

    private  String userContact;

    @Enumerated(value = EnumType.STRING)
    private Gender userGender;
}
