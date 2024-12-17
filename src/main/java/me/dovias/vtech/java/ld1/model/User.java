package me.dovias.vtech.java.ld1.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import me.dovias.vtech.java.ld1.type.UserType;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    public UserType type;

    @Column(unique = true)
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
}
