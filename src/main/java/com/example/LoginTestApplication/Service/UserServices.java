package com.example.LoginTestApplication.Service;


import com.example.LoginTestApplication.Entity.Users;
import com.example.LoginTestApplication.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users users){
        return userRepository.save(users);
    }

    public Users getUserById(int id){
        return userRepository.getById(id);
    }
}
