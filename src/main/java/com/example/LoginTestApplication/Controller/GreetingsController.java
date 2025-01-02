package com.example.LoginTestApplication.Controller;


import com.example.LoginTestApplication.Entity.RoleEntity;
import com.example.LoginTestApplication.Entity.UserEntity;
import com.example.LoginTestApplication.Service.CustomUserService;
import com.example.LoginTestApplication.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @Autowired
    private CustomUserService customUserService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/hello")
    public String greetings(){
        return "hello";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userEndpoint(){
        return "user";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminEndpoint(){
        return "admin";
    }

    @PostMapping("/createUser")
    public UserEntity postUserEndpoint(){
        return customUserService.createUser("harsh","pass","USER");
    }

    @PostMapping("/addRole")
    public RoleEntity putRole(@RequestBody RoleEntity role){
        return roleService.addRole(role);
    }
}
