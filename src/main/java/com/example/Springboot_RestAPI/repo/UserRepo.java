package com.example.Springboot_RestAPI.repo;

import com.example.Springboot_RestAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
