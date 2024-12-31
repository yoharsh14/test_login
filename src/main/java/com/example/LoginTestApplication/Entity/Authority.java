package com.example.LoginTestApplication.Entity;


import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Id
    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username", nullable = false)
    private Users user;


    @Id
    @Column(name = "authority", length = 50, nullable = false)
    private String authority;
}
