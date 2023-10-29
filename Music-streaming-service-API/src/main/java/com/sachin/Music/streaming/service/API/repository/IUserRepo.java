package com.sachin.Music.streaming.service.API.repository;

import com.sachin.Music.streaming.service.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);
}
