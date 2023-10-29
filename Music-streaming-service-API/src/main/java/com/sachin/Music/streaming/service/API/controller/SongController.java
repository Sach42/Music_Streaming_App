package com.sachin.Music.streaming.service.API.controller;

import com.sachin.Music.streaming.service.API.model.Song;
import com.sachin.Music.streaming.service.API.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("songs")
    public List<Song> getAllSongs()
    {
        return  songService.getAllSongs();
    }

    @DeleteMapping("song")
    public  String deleteSongById(@PathVariable Integer id){
        return songService.deleteSongById(id);
    }
}
