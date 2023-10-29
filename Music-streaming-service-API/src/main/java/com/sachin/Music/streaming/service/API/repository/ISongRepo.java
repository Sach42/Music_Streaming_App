package com.sachin.Music.streaming.service.API.repository;

import com.sachin.Music.streaming.service.API.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song,Integer> {
}
