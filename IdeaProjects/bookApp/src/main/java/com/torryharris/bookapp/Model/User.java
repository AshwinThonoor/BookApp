package com.torryharris.bookapp.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int sNo;
    private String userName;
    private String email,password;
}
