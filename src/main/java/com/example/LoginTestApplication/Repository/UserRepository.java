package com.example.LoginTestApplication.Repository;

import com.example.LoginTestApplication.Entity.Role;
import com.example.LoginTestApplication.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
    List<Role> getRoles();
}
