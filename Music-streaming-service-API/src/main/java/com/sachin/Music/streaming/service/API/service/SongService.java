package com.sachin.Music.streaming.service.API.service;

import com.sachin.Music.streaming.service.API.model.Song;
import com.sachin.Music.streaming.service.API.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    ISongRepo songRepo;

    public List<Song> getAllSongs() {
        return songRepo.findAll();
    }

    public String addSong(Song newSong) {
        Integer songId = newSong.getSongId();

        if(songId != null && songRepo.existsById(songId))
        {
            return  "song already exits";
        }

        songRepo.save(newSong);
        return  "song added";
    }

    public String deleteSongById(Integer id) {
        songRepo.deleteById(id);
        return "deleted";
    }
}
