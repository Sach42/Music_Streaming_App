package com.sachin.Music.streaming.service.API.service;

import com.sachin.Music.streaming.service.API.model.PlayList;
import com.sachin.Music.streaming.service.API.model.Song;
import com.sachin.Music.streaming.service.API.model.User;
import com.sachin.Music.streaming.service.API.repository.IPlayListRepo;
import com.sachin.Music.streaming.service.API.repository.ISongRepo;
import com.sachin.Music.streaming.service.API.repository.ITokenRepo;
import com.sachin.Music.streaming.service.API.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {
    @Autowired
    IPlayListRepo playListRepo;

    @Autowired
    ISongRepo songRepo;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    TokenService tokenService;

    public String createPlayList(PlayList playList) {
        return playListRepo.save(playList).toString();
    }


    public List<PlayList> getPlayList() {
        return  playListRepo.findAll();
    }

    public String deletePlaylist(Integer playListId) {
        playListRepo.deleteById(playListId);
        return  "deleted";
    }
}
