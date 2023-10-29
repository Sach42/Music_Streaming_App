package com.sachin.Music.streaming.service.API.repository;

import com.sachin.Music.streaming.service.API.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayListRepo extends JpaRepository<PlayList,Integer> {
}
