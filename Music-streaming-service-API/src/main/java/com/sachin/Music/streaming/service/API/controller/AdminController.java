package com.sachin.Music.streaming.service.API.controller;

import com.sachin.Music.streaming.service.API.model.Song;
import com.sachin.Music.streaming.service.API.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    SongService songService;

    @PostMapping("song")
    public  String addSong(@RequestBody Song newSong)
    {
        return songService.addSong(newSong);
    }


}
