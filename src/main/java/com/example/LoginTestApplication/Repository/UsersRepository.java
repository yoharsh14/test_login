package com.example.LoginTestApplication.Repository;

import com.example.LoginTestApplication.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
}
