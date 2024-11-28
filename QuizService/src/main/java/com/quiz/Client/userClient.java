package com.quiz.Client;

import java.util.Optional;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.quiz.Model.Users;

@FeignClient(name = "userservice-app", url = "http://app2:8081/")
public interface userClient {

    @GetMapping("user/profile")
    ResponseEntity<Users> getProfile(@RequestHeader("Authorization") String token);

} 
