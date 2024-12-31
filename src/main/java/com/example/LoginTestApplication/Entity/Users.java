package com.example.LoginTestApplication.Entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name="username",nullable = false)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="enabled", nullable = false)
    private boolean enabled;
}
