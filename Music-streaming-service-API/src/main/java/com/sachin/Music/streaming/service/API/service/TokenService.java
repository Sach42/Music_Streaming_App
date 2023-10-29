package com.sachin.Music.streaming.service.API.service;

import com.sachin.Music.streaming.service.API.model.AuthenticationToken;
import com.sachin.Music.streaming.service.API.model.dto.AuthenticationInputDto;
import com.sachin.Music.streaming.service.API.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    ITokenRepo tokenRepo;

    public void createToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public void deleteToken(String tokenValue) {
        AuthenticationToken token = tokenRepo.findFirstByTokenValue(tokenValue);
        tokenRepo.delete(token);
    }

    public boolean authenticate(AuthenticationInputDto authInfo) {
        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        //find the actual token ---> get the connected user -> get its email -> verify with passed email
     // return   tokenRepo.findFirstByTokenValue(tokenValue).getUser().getUserEmail().equals(email);

        AuthenticationToken token =  tokenRepo.findFirstByTokenValue(tokenValue);
        if(token != null)
        {
            return token.getUser().getUserEmail().equals(email);
        }else {
            return false;
        }
    }
}
