package com.sachin.Music.streaming.service.API.service;

import com.sachin.Music.streaming.service.API.model.AuthenticationToken;
import com.sachin.Music.streaming.service.API.model.PlayList;
import com.sachin.Music.streaming.service.API.model.Song;
import com.sachin.Music.streaming.service.API.model.User;
import com.sachin.Music.streaming.service.API.model.dto.AuthenticationInputDto;
import com.sachin.Music.streaming.service.API.model.dto.SignInInputDto;
import com.sachin.Music.streaming.service.API.repository.IPlayListRepo;
import com.sachin.Music.streaming.service.API.repository.ISongRepo;
import com.sachin.Music.streaming.service.API.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    TokenService tokenService;

    @Autowired
    ISongRepo songRepo;

    @Autowired
    IPlayListRepo playListRepo;

    public String userSignUp(User user) {
        //check if already user email exits -> try logging in

        String newEmail = user.getUserEmail();

      User existingUser =  userRepo.findFirstByUserEmail(newEmail);

      if(existingUser != null)
      {
          return  "email already in use";
      }
      // password are encrypted before we store in it table
       String signUpPassword = user.getUserPassword();
        try {
            String encryptedPassword = PasswordEncrypter.encrypt(signUpPassword);

            user.setUserPassword(encryptedPassword);

            //save in user table
            userRepo.save(user);
            return "user registered";
        } catch (NoSuchAlgorithmException e) {
            return "Internal issue while saving password";
        }
    }

    public String userSignIn(SignInInputDto signInInput) {

        //check if the email is present in your table
        String email = signInInput.getEmail();

        User existingUser = userRepo.findFirstByUserEmail(email);

        //sign in only possible if user already signup
        if(existingUser == null)
        {
            return "not a valid email";
        }
        //password should be matched
        String password = signInInput.getPassword();
        try {
            String encryptedPassword = PasswordEncrypter.encrypt(password);

            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                AuthenticationToken token = new AuthenticationToken(existingUser);
                tokenService.createToken(token);
                return token.getTokenValue();
            }else{
                return  "Invalid Credentials!!!!";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Internal issue while saving password";
        }
    }

    public String userSignOut(AuthenticationInputDto authInfo) {

        if(tokenService.authenticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            tokenService.deleteToken(tokenValue);
            return "Sign out successful!!";
        }else
        {
            return "Un Authenticated access!!!";
        }

    }

    public String addUserPlayList(Integer songId, Integer playListId) {
        Optional<Song> newSong = songRepo.findById(songId);
        Optional<PlayList> newPlayList = playListRepo.findById(playListId);


        playListRepo.save(newPlayList.get());
        return "playList added";
    }
}
