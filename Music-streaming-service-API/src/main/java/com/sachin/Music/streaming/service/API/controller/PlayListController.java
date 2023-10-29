package com.sachin.Music.streaming.service.API.controller;

import com.sachin.Music.streaming.service.API.model.PlayList;
import com.sachin.Music.streaming.service.API.service.PlayListService;
import com.sachin.Music.streaming.service.API.service.SongService;
import com.sachin.Music.streaming.service.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayListController {
    @Autowired
    PlayListService playListService;
    @Autowired
    UserService userService;
    @Autowired
    SongService songService;

    @PostMapping("PlayList")
    public String createPlayList(@RequestBody PlayList playList ){
        return  playListService.createPlayList(playList);
    }

    @GetMapping("PlayList")
    public  List<PlayList> getPlayList(){
        return playListService.getPlayList();
    }

    @DeleteMapping("playList")
    public  String deletePlaylist(@PathVariable Integer PlayListId)
    {
        return  playListService.deletePlaylist(PlayListId);
    }
}
