package com.example.GameBaron.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.core.annotation.Order;

@Entity
@Table(name = "Users")
@Order(1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @Column(unique = true)
    @NotBlank(message = "The username field is mandatory!")
    private String UserName;

    @NotBlank(message = "The password field is mandatory!")
    @Size(min = 4)
    private String Password;

    @NotBlank(message = "The email field is mandatory!")
    private String Email;

    public User() {
    }

    public User(String userName, String password, String email) {
        UserName = userName;
        Password = password;
        Email = email;
    }

    public User(Long userId, String userName, String password, String email) {
        UserId = userId;
        UserName = userName;
        Password = password;
        Email = email;
    }

    public Long getUserId() {
        return UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
