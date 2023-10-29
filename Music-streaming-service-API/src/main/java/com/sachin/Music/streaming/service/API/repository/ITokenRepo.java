package com.sachin.Music.streaming.service.API.repository;

import com.sachin.Music.streaming.service.API.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findFirstByTokenValue(String tokenValue);
}
