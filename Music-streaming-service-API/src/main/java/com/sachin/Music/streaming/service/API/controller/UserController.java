package com.sachin.Music.streaming.service.API.controller;

import com.sachin.Music.streaming.service.API.model.PlayList;
import com.sachin.Music.streaming.service.API.model.User;
import com.sachin.Music.streaming.service.API.model.dto.AuthenticationInputDto;
import com.sachin.Music.streaming.service.API.model.dto.CreatePlayListDto;
import com.sachin.Music.streaming.service.API.model.dto.SignInInputDto;
import com.sachin.Music.streaming.service.API.service.PlayListService;
import com.sachin.Music.streaming.service.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PlayListService playListService;


    //sign-up
    @PostMapping("user/signup")
    public String userSignUp(@RequestBody User user)
    {
        return userService.userSignUp(user);
    }

    //sign-in
    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody SignInInputDto signInInput)
    {
        return userService.userSignIn(signInInput);
    }


    //sign-out
    @DeleteMapping("user/signOut")
    public  String userSignOut(@RequestBody AuthenticationInputDto authInfo)
    {
        return userService.userSignOut(authInfo);
    }

    @PostMapping("user/playlist/song")
    public String addUserPlayList(@PathVariable Integer SongId, @PathVariable Integer PlayListId)
    {
        return  userService.addUserPlayList(SongId,PlayListId);
    }
}
