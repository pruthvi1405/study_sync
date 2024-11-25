package com.user.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.Model.Users;
import java.util.List;


public interface UserRepo extends JpaRepository<Users,UUID>{
    Users findByuserName(String username);
    Users findByEmail(String email);
}