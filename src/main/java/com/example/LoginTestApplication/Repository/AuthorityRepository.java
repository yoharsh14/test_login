package com.example.LoginTestApplication.Repository;

import com.example.LoginTestApplication.Entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}
