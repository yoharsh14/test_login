package com.example.LoginTestApplication.Entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AuthorityId {

    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
