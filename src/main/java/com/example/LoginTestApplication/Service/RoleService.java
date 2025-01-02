package com.example.LoginTestApplication.Service;

import com.example.LoginTestApplication.Entity.RoleEntity;
import com.example.LoginTestApplication.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity addRole(RoleEntity role){
       return roleRepository.save(role);
    }
}
